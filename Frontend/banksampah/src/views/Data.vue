<template>
  <div class="data" :class="mode">
  <Header :mode="mode" @toggle="toggle" />
      <Nasabah />
  </div>
</template>

<script>
import Nasabah from '@/components/Nasabah.vue'
import Header from '@/components/Header.vue'


export default {
    name: 'data',
    data () {
    return {
      mode: 'light'
    }
  },
    components: {
        Nasabah,
        Header
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

<style scoped>
h3 {
    margin: 40px 0 0;
}
ul{
    list-style-type: none;
    padding: 0;
}
li{
    display: inline-block;
    margin: 0 10px;
}
a {
    color: aquamarine;
}
</style>