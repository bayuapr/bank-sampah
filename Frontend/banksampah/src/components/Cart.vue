<template>
  <div>
      <b-container>

          <b-row>
              <b-col>
                  <h2>Pilih Jenis Sampah</h2>
              </b-col>
          </b-row>

          <b-row>
              <b-col v-for="sampah in Sampah" :key="sampah.id">
                  <b-card
                   :title= 'sampah.jenis'
                   :img-src= "require(`@/assets/sampah${sampah.id}.jpg`)"
                    img-alt="Image"
                    img-top
                    tag="article"
                    style="max-width: 20rem;"
                    class="mb-2"
                   >

                    <b-card-text>
                        Harga:{{sampah.harga}}
                    </b-card-text>

                    <b-button v-if="!sampah.cart" @click="add(sampah)" href="#" variant="primary">Tambah Transaksi Sampah</b-button>
                    <b-button v-if="sampah.cart" @click="add(sampah)" :disabled="sampah.cart" href="#" variant="warning">Sampah Ditambahkan Ketransaksi</b-button>
                  </b-card>
              </b-col>
          </b-row>


            <!-- CART -->
          <b-row>
              <b-col>
                  <h2>Transaksi Cart</h2>
              </b-col>
          </b-row>

          <b-row>
              <b-col>
                  <b-table bordered hover :items="cart" :fields="fields">

                      <template slot="id" slot-scope="data" >
                          {{ data.index+1}}
                      </template>

                      <template slot="harga" slot-scope="data" >
                          {{ data.item.harga * data.item.quantity}}
                      </template>
                      
                      <template v-slot:cell(remove)="data" >
                          <b-button @click="remove(data.item.id)" variant="danger" class="mr-2">
                            X
                          </b-button>
                     </template>

                     <template v-slot:cell(quantity)="data">
                         <b-row>
                             <b-col cols="5">
                                 <b-button :disabled="data.item.quantity <=1" variant="primary" 
                                 @click="decrement(data.item.id)" class="mr-2"> 
                                 - 
                                 </b-button>
                             </b-col>

                             <b-col cols="2">
                                 <h4>{{data.item.quantity}}</h4>
                             </b-col>

                             <b-col cols="5">
                                 <b-button variant="primary" @click="increment(data.item.id)" class="mr-2"> 
                                 +
                                  </b-button>
                             </b-col>
                         </b-row>
                     </template>
                      
                      <template v-slot:cell(image)="data">
                          <b-img style="max-width: 5rem;" :src="require(`@/assets/sampah${data.item.id}.jpg`)" fluid alt="Responsive image"></b-img>
                      </template>

                  </b-table>
              </b-col>
          </b-row>

          <b-row v-if="cart.length > 0">
              <b-col></b-col>
              <b-col></b-col>
              <b-col></b-col>
              <b-col></b-col>
              <b-col><h3>Total</h3></b-col>
              <b-col><h3>Rp. {{ total }}</h3></b-col>
          </b-row>

          <b-row v-if="cart.length > 0">
          <b-col>
              <b-button @click="clean" variant="info" block class="mr-2">
                  Clean
              </b-button>
          </b-col>
          <b-col></b-col>
           <b-col cols="4">Bank Sampah - Fullstack Praxis 2020</b-col>
           <b-col>

           </b-col>
           <b-col>
               <b-button @click="buy" variant="success" block class="mr-2"> 
                   Masuk
                   </b-button>
           </b-col>
           </b-row>
           <b-modal hide-header-close no-close-on-esc no-close-on-backdrop ref="modal-1" centered title="Transaksi Berhasil">
               <template slot="modal-footer">
                   <b-button class="mt-3" variant="info" block @click="clean">Close</b-button>


               </template>
               <p class="my-4">Sampah:</p>
               <ul v-for="sampahFinal in ticket.Sampah" :key="sampahFinal.id">
                   <li>
                       Jenis Sampah: {{ sampahFinal.jenis}}
                   </li>
                   <li>
                       Quantity: {{ sampahFinal.quantity }} 
                   </li>
                   <li>
                       Harga: {{ sampahFinal.harga }}
                   </li>
                   <li>
                       Total: {{ sampahFinal.harga * sampahFinal.quantity}}
                   </li>
                   <hr>
               </ul>
               <h2 class="my-4">Total: Rp. {{ticket.total}}</h2>


           </b-modal>

      </b-container>
  </div>
</template>

<script>
export default {
    name: 'Cart',
    // props:{
    //     msg: String
    // },
    data(){
        return{
            ticket:{
                Sampah: null,
                total:0
            },
            counter:0,
            Sampah:[
        {
            id:1,
            img:'@/assets/sampah1.jpg',
            jenis:'Organik',
            harga: 1000,
            cart: false,
            quantity:1,
        },
         {
            id:2,
            img:'@..assets/sampah2.jpg',
            jenis:'Non-Organik',
            harga: 2000,
            cart: false,
            quantity:1

        },
         {
            id:3,
            img:'@/assets/sampah3.jpg',
            jenis:'Botol',
            harga: 3000,
            cart: false,
            quantity:1

        }

            ],
            cart:[],
            fields: ['id', 'remove', 'image', 'jenis', 'quantity', 'harga']

        }//data return
    },
    methods: {
        add(sampah){
            this.Sampah[sampah.id-1].cart=true
            this.cart.push(sampah)
            this.counter++

        },
        clean(){
            this.cart=[];

            for (const key in this.Sampah) {
                this.Sampah[key].cart=false
                this.Sampah[key].quantity=1
            }
            this.$refs['modal-1'].hide()
        },
        remove(id){
            for (let index = 0; index < this.Sampah.length; index++){
                if(this.Sampah[index].id == id){
                    this.Sampah[index].cart=false
                    this.Sampah[index].quantity=1
                }
            }
            for(let index = 0; index < this.cart.length; index++){
                if(this.cart[index].id == id){
                    this.cart.splice(index,1);

                }
            }
        },
        buy(){
            this.ticket={
                Sampah: this.cart,
                total: this.total
            }
            this.$refs['modal-1'].show()

        }, 
        increment(id){
            for (let index = 0; index < this.cart.length; index++){
                if(this.cart[index].id == id){
                    this.cart[index].quantity++
                }
            }
        },
        decrement(id){
            for (let index = 0; index < this.cart.length; index++){
                if(this.cart[index].id == id){
                    this.cart[index].quantity--
            }
        }
    }
},
computed: {
    total(){
        let t =0;
        for (let index = 0; index < this.cart.length; index++){
            t += this.cart[index].harga*this.cart[index].quantity
        }
        return t
    }
}
}
</script>

<style scoped>

</style>