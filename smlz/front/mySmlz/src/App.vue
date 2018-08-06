<template>
  <div id="app">
  	<keep-alive>
  		<router-view/>
  	</keep-alive>
    
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
html,body{
	margin: 0;
	height: 100%;
}
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  height: 100%;
}
</style>
