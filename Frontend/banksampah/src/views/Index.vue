<template>
  <div class="index" :class="mode">  
  <Header :mode="mode" @toggle="toggle" />
  <Cart />
  </div>
</template>

<script>
import Header from '@/components/Header.vue'
import Cart from '@/components/Cart.vue'

export default {
  name: 'Index',
  data () {
    return {
      mode: 'light'
    }
  },
  components: {
    Header,
    Cart
    
  },
  created () {
    window.addEventListener('keyup', this.keyPress)
  },
  methods: {
    keyPress (e) {
      if (e.key === 't') {
        this.toggle()
      }
    },
    toggle () {
      if (this.mode === "dark") {
        this.mode = "light"
      } else {
        this.mode = "dark"
      }
    }
  }
}
</script>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Roboto', sans-se•••rif;
}
.app {
  width: 100vw;
  min-height: 100vh;
  background: #F3F3F3;
  color: #15202B;
  transition: background 0.3s ease-in-out;
}
.dark {
  background: #192734;
  color: #E8E8E8;
}
</style>