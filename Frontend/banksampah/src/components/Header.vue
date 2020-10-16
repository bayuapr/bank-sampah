<template>
  <header>
    <Toggle :mode="mode" @toggle="$emit('toggle')" />
    <nav>
      <b-nav-item class="nav-item" href="index">Dashboard</b-nav-item>
      <b-nav-item class="nav-item" href="http://localhost:8080/transaksi">Transaksi</b-nav-item>
      <b-nav-item class="nav-item" href="#">About</b-nav-item>
      <b-nav-item class="nav-item" href="http://localhost:8080/">Logout</b-nav-item>
    </nav>
  </header>
</template>

<script>
import Toggle from '@/components/Toggle.vue'
export default {
  props: ['mode'],
  components: {
    Toggle
  }
}
</script>

<style>
header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0px 25px;
  height: 60px;
  background: #C3C3C3;
  transition: background 0.3s ease-in-out;
}
.dark header {
  background: #15202B;
}
header h1 {
  font-size: 32px;
  text-transform: uppercase;
  font-weight: 900;
}
header nav {
  display: flex;
  height: 60px;
}
header nav .nav-item {
  display: flex;
  align-items: center;
  padding: 0px 15px;
}
header nav .nav-item:hover {
  background: #B0B0B0;
}
.dark header nav .nav-item:hover {
  background: #101520;
}
</style>