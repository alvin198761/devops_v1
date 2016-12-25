<template>
	<el-row class="panel">
		<el-col :span="24" class="panel-top">
			<el-col :span="20" style="font-size:26px;">
				<img src="../assets/logo4.png" class="logo"> <span>远程<i style="color:#20a0ff">管理系统</i></span>
			</el-col>
			<el-col :span="4">
				<el-tooltip class="item tip-logout" effect="dark" content="退出" placement="bottom" style="padding:0px;">
					<!--<i class="logout" v-on:click="logout"></i>-->
					<i class="fa fa-sign-out" aria-hidden="true" v-on:click="logout"></i>
				</el-tooltip>
			</el-col>
		</el-col>
		<el-col :span="24" class="panel-center">
			<!--<el-col :span="4">-->
			<aside style="width:230px;">
				<h5 class="admin"><i class="fa fa-user" aria-hidden="true" style="margin-right:5px;"></i>欢迎系统管理员：测试</h5>
				<el-menu style="border-top: 1px solid #475669;" :default-active="selectedKey" :default-openeds="openNode" class="el-menu-vertical-demo" @open="handleopen"
					@close="handleclose" @select="handleselect" theme="dark" unique-opened router>
					<el-submenu index="1">
						<template slot="title"><i class="el-icon-menu"></i>资源管理</template>
						<el-menu-item index="/room">机房</el-menu-item>
						<!--<el-menu-item index="/project">项目</el-menu-item>-->
						<el-menu-item index="/device">服务器</el-menu-item>
					</el-submenu>
					<el-submenu index="4">
                    	<template slot="title"><i class="el-icon-message"></i>文件管理</template>
                    	 <el-menu-item index="/files">文件操作</el-menu-item>
                     </el-submenu>
					<el-submenu index="2">
						<template slot="title"><i class="el-icon-date"></i>远程操作</template>
						<el-menu-item index="/cmd">命令执行</el-menu-item>
						<el-menu-item index="/task">执行任务</el-menu-item>
					</el-submenu>
					<el-submenu index="3">
					<template slot="title"><i class="el-icon-setting"></i>系统权限</template>
                       <el-menu-item index="/user">用户/权限</el-menu-item>
                       <el-menu-item index="/sys">系统设置</el-menu-item>
					</el-submenu>
				</el-menu>
			</aside>
			<!--</el-col>-->
			<!--<el-col :span="20" class="panel-c-c">-->
			<section class="panel-c-c">
				<div class="grid-content bg-purple-light">
					<el-col :span="24" style="margin-bottom:15px;">
						<el-breadcrumb separator="/" >
							<el-breadcrumb-item :to="{ path: '/table' }">首页</el-breadcrumb-item>
							<el-breadcrumb-item>{{currentPathNameParent}}</el-breadcrumb-item>
							<el-breadcrumb-item>{{currentPathName}}</el-breadcrumb-item>
						</el-breadcrumb>
					</el-col>
					<el-col :span="24" style="background-color:#fff;box-sizing: border-box;">
						<transition name="fade">
							<router-view></router-view>
						</transition>
					</el-col>
				</div>
			</section>
			<!--</el-col>-->
		</el-col>
	</el-row>
</template>

<script>
  export default {
    data() {
      return {
		  currentPathName:'room',
		  currentPathNameParent:'导航一',
		  selectedKey:'/room',
		  openNode:[1],
        form: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        }
      }
    },
	watch: {
		'$route' (to, from) {//监听路由改变
//			console.log(to)
			this.currentPathName=to.name;
			this.currentPathNameParent=to.matched[0].name;
		}
	},
    methods: {
      onSubmit() {
        console.log('submit!');
      },
			handleopen(){
				//console.log('handleopen');
			},
			handleclose(){
				//console.log('handleclose');
			},
            handleselect:function(a,b){
            },
			//退出登录
			logout:function(){
				var _this=this;
				this.$confirm('确认退出吗?', '提示', {
					//type: 'warning'
				}).then(() => {
					_this.$router.replace('/login');
				}).catch(() => {
							
				});

				
			}
    }
  }
</script>

<style >
	.fade-enter-active,
	.fade-leave-active {
		transition: opacity .5s
	}
	
	.fade-enter,
	.fade-leave-active {
		opacity: 0
	}
	
	.panel {
		position: absolute;
		top: 0px;
		bottom: 0px;
		width: 100%;
	}
	
	.panel-top {
		height: 60px;
		line-height: 60px;
		background: #1F2D3D;
		color: #c0ccda;
	}
	
	.panel-center {
		background: #324057;
		position: absolute;
		top: 60px;
		bottom: 0px;
		overflow: hidden;
	}
	
	.panel-c-c {
		background: #f1f2f7;
		position: absolute;
		right: 0px;
		top: 0px;
		bottom: 0px;
		left: 230px;
		overflow-y: scroll;
		padding: 20px;
	}
	
	.logout {
		background: url(../assets/logout_36.png);
		background-size: contain;
		width: 20px;
		height: 20px;
		float: left;
	}
	
	.logo {
		width: 40px;
		float: left;
		margin: 10px 10px 10px 18px;
	}
	
	.tip-logout {
		float: right;
		margin-right: 20px;
		padding-top: 5px;
		cursor: pointer;
	}
	
	.admin {
		color: #c0ccda;
		text-align: center;
	}
</style>