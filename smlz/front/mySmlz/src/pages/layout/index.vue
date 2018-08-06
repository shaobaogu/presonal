<template>
	<div>
		<div class="nav" :class="{model: isModel}">
			<div class="menu">
				<div v-for="(item, index) in menus" :key="index" class="menu-list" :class="{active: ind == index}"><a @click="open(item,index)">{{item.name}}</a></div>
			</div>
			<div class="content">
				<iframe v-if="ind != menus.length-1" :src="path" width="100%" frameborder="0"></iframe>
				<div v-else class="presonale">
					<div>
						<h4>个人信息</h4>
						<div style="width: 80vw;">
							<table border="1" width="80%" cellspacing="0" cellpadding="0">
								<tr><th width="20%">标识</th><th>信息</th><th width="10%">备注</th></tr>
								<tr v-for="it of person"><td>{{it.tag}}</td><td>{{it.text}}</td><td>{{it.mark}}</td></tr>
							</table>
						</div>
					</div>
					<div>
						<h4>个人爬虫</h4>
						<div>
							爬虫信息，正在规划中。。。
						</div>
					</div>
				</div>
				<!--<object :data="path" type=""></object>-->
			</div>
		</div>	
		<div class="save-btn" @click="isModel = true">
			
		</div>
		<div class="save" v-if="isModel">
			<h5>添加频道</h5>
			<form>
				<label>名称：<input type="text" v-model="saveForm.name"/></label>
				<label>地址：<input type="url" v-model="saveForm.path"/></label>
			</form>
			<div class="btn">
				<button @click="save" style="background-color: #63B8FF;">保存</button>
				<button @click="isModel = false">取消</button>
			</div>
		</div>
	</div>
</template>

<script>
	export default{
		data(){
			return {
				menus:[
//					{name: '知乎频道',path: 'https://www.zhihu.com/'},
					{name: '百度频道',path:  'https://www.baidu.com'},
					{name: '掘金频道',path:  'https://juejin.im/'},
					{name: '博客园频道',path:  'https://www.cnblogs.com/'},
					{name: '小程序频道',path:  'https://developers.weixin.qq.com/miniprogram/dev/'},
					{name: '码云频道',path:  'https://gitee.com/'},
					{name: '麦苗频道',path:  'http://admin.mmiauto.com'},
					{name: '颜色频道',path: 'https://www.114la.com/other/rgb.htm'},
					{name: 'HTML CSS 特殊字符表',path: 'https://blog.csdn.net/bluestarf/article/details/40652011'},
					{name: '个人频道',path:  ''}
				],
				ind: 0,
				path: '',
				isModel: false,
				saveForm:{},
				person:[]
			}
		},
		methods:{
			open(val,i){
				this.ind = i
				this.path = val.path
			},
			save(){
				var bools = true
				this.menus.forEach(o=>{
					if(o.name == this.saveForm.name || o.path == this.saveForm.path){
						alert("内容已存在");
						bools = false
					}
				});
				console.log(bools,"fff")
				if(bools){
					this.menus.push(this.saveForm)
					this.isModel = false
				}
			},
			// 获取表格信息
			getPerson(){
				this.$http.get('/static/person.json').then(res=>{
					console.log(res.data)
					this.person = res.data
				}).catch()
			}
		},
		created(){
			var i = 1 
			this.open(this.menus[i],i);
		},
		mounted(){
			this.getPerson()
		}
	}
</script>

<style>
	ul,li{
		list-style-type: none;
	}
	h4{
		background-color: #D9D9D9;
		padding: 10px 0;
	}
	.nav{
		display: flex;
		flex-flow: row nowrap;
		align-items: center;
		min-height: 100%;
	}
	.menu{
		display: flex;
		flex-direction: column;
		border-right: 1px solid #D9D9D9;
		min-height: 100vh;
		min-width: 10em;
	}
	.menu-list{
		padding: 10px;
		cursor: pointer;
	}
	.menu-list:before{
		content: '\266C';
		position: relative;
		left: -8px;
	}
	.menu-list:after{
		content: '\2764';
		color: red;
		font-size: 1px;
		position: relative;
		top: -6px;
	}
	.active{
		background-color: #ff9800;
		color: white;
		/*border-bottom: 2px solid #e4e4e4;*/
	}
	.content{
		flex: 1;
	}
	.content iframe{
		min-height: 100vh;
	}
	.presonale{
		margin-top: 50px;
		margin-left: 20px;
		position: absolute;
		top: 0;
	}
	.presonale table{
		border-collapse: collapse;
	}
	.presonale table td,th{
		text-align: center;
		padding: 10px 0;
	}
	.save{
		position: fixed;
		top: 30%;
		left: 25%;
		right: 25%;
		z-index: 9999;
		border: 1px solid #D9D9D9;
		border-radius: 5px;
		min-height: 20em;
		background-color: #F5FFFA;
	}
	.model{
		opacity: 0.1;
	}
	.btn{
		position: absolute;
		bottom: 10px;
		width: 100%;
		display: flex;
		flex-direction: row-reverse;
		justify-content: flex-start;
	}
	.btn button{
		margin-right: 40px;
		padding: 10px 20px;
	}
	.save form{
		display: flex;
		height: 5em;
		flex-flow: column nowrap;
		justify-content: space-between; 
	}
	.save form input{
		border-radius: 4px;
		padding: 5px;
		width: 80%;
	}
	.save-btn{
		position: fixed;
		bottom: 5px;
		left: 10px;
		width: 40px;
		height: 40px;
		border-radius: 50%;
		background-color: #63B8FF;
	}
	.save-btn:before{
		content: '?';
		color: 	#71C671;
	}
</style>