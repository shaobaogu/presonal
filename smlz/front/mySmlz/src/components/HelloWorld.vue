<template>
	<div>
		<div style="width: 100%; color: #ee44ff;text-align: center;margin-bottom: 50px;">使用Python+pyspider爬蟲技術通過國家統計局網站獲取的國內行政區域信息</div>
		<div class="hello" v-for="(item,index) in addrData" :key="index">
			<h6>{{item.name}}</h6>
			<h6>{{item.type}}</h6>
		</div>

	</div>
</template>

<script>
	export default {
		name: 'HelloWorld',
		data() {
			return {
				addrData: []
			}
		},
		created() {
			this.$http.get('http://192.168.10.222:8080/get-level-one').then(res => {
				console.log(res.data)
				this.addrData = res.data
			}).catch()
		}
	}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
	.hello {
		display: flex;
		flex-flow: row nowrap;
		justify-content: space-around;
		align-items: center;
		border-bottom: 2px solid #d9d9d9;
	}
</style>