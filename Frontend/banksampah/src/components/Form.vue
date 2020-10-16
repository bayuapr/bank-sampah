<template>
  <div class="hello">
    <b-container>
      <b-row class="justify-content-md-center" cols="10">
        <b-col style="margin-top:25vh;" cols="6">
          <hr>
          <h2>LOGIN</h2>
          <hr>
          <b-form @submit="onSubmit" @reset="onReset" v-if="show">
            <b-form-group 
              id="input-group-1"
              label=" "
              label-for="input-1">
              <b-form-input 
                id="input-1"
                v-model="form.user"
                type="text"
                required
                placeholder="Enter User"
              ></b-form-input>
              </b-form-group>

              <b-form-group 
              id="input-group-2"
              label=" "
              label-for="input-2">
              <b-form-input 
                id="input-2"
                v-model="form.password"
                type="password"
                required
                placeholder="Enter Password"
              ></b-form-input>
              </b-form-group>
              <b-button type="submit" class="mr-4" variant="primary">Submit</b-button>
              <b-button type="reset" variant="danger">Reset</b-button>
              <b-alert show variant="danger mt-4"  v-if="con">USER ATAU PASSWORD SALAH</b-alert>

          </b-form>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
export default {
  name: 'Form',
  data() {
    return{
      form:{
        user: '',
        password: '',
      },
      show: true,
      con:false
    }
  },
  methods: {
    onSubmit(evt){
      evt.preventDefault()
      if(this.form.user=='admin' && this.form.password=='123456'){
        this.$router.push('index')
      } else{
        this.con=true
      }
    },
    onReset(evt){
      evt.preventDefault()

      this.form.user = ''
      this.form.password = ''
      this.con=false

      this.show = false
      this.$nextTick(() =>{
        this.show = true
      })
    }
    
  }
}
</script>

<style>

</style>