<template>
  <div class="transaksi">
      <Cart />
  </div>
</template>

<script>
import Cart from '@/components/Cart.vue'
export default {
    name: 'transaksi',
    components: {
        Cart
    }
}
</script>

<style>
#cart {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>