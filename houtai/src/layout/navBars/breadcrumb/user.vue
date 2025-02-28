<template>
	<div class="layout-navbars-breadcrumb-user" :style="{ flex: layoutUserFlexNum }">
		<el-dropdown :show-timeout="70" :hide-timeout="50" @command="onDropdownCommand">
			<span class="layout-navbars-breadcrumb-user-link">
				<img :src="getUserInfos.avater" class="layout-navbars-breadcrumb-user-link-photo mr5" />
				{{ getUserInfos.username === '' ? 'test' : getUserInfos.username }}
				<i class="el-icon-arrow-down el-icon--right"></i>
			</span>
			<el-dropdown-menu slot="dropdown">
				<el-dropdown-item command="/home">{{ $t('message.user.dropdown1') }}</el-dropdown-item>
				<el-dropdown-item divided command="logOut">{{ $t('message.user.dropdown5') }}</el-dropdown-item>
			</el-dropdown-menu>
		</el-dropdown>
		<Search ref="searchRef" />
	</div>
</template>

<script>
import screenfull from 'screenfull';
import { Session, Local } from '@/utils/storage.js';
import UserNews from '@/layout/navBars/breadcrumb/userNews.vue';
import Search from '@/layout/navBars/breadcrumb/search.vue';
export default {
	name: 'layoutBreadcrumbUser',
	components: { UserNews, Search },
	data() {
		return {
			isScreenfull: false,
			isShowUserNewsPopover: false,
			disabledI18n: 'zh-cn',
			disabledSize: '',
		};
	},
	computed: {
		// 获取用户信息
		getUserInfos() {
			return this.$store.state.userInfos.userInfos;
		},
		// 设置弹性盒子布局 flex
		layoutUserFlexNum() {
			let { layout, isClassicSplitMenu } = this.$store.state.themeConfig.themeConfig;
			let num = '';
			if (layout === 'defaults' || (layout === 'classic' && !isClassicSplitMenu) || layout === 'columns') num = 1;
			else num = null;
			return num;
		},
	},
	mounted() {
		if (Local.get('themeConfigPrev')) {
			this.initI18n();
			this.initComponentSize();
		}
	},
	methods: {
		// 搜索点击
		onSearchClick() {
			this.$refs.searchRef.openSearch();
		},
		// 布局配置点击
		onLayoutSetingClick() {
			this.bus.$emit('openSetingsDrawer');
		},
		// 全屏点击
		onScreenfullClick() {
			if (!screenfull.isEnabled) {
				this.$message.warning('暂不不支持全屏');
				return false;
			}
			screenfull.toggle();
			screenfull.on('change', () => {
				if (screenfull.isFullscreen) this.isScreenfull = true;
				else this.isScreenfull = false;
			});
			// 监听菜单 horizontal.vue 滚动条高度更新
			this.bus.$emit('updateElScrollBar');
		},
		// 组件大小改变
		onComponentSizeChange(size) {
			Local.remove('themeConfigPrev');
			this.$store.state.themeConfig.themeConfig.globalComponentSize = size;
			Local.set('themeConfigPrev', this.$store.state.themeConfig.themeConfig);
			this.$ELEMENT.size = size;
			this.initComponentSize();
			window.location.reload();
		},
		// 语言切换
		onLanguageChange(lang) {
			Local.remove('themeConfigPrev');
			this.$store.state.themeConfig.themeConfig.globalI18n = lang;
			Local.set('themeConfigPrev', this.$store.state.themeConfig.themeConfig);
			this.$i18n.locale = lang;
			this.initI18n();
		},
		// 初始化言语国际化
		initI18n() {
			switch (Local.get('themeConfigPrev').globalI18n) {
				case 'zh-cn':
					this.disabledI18n = 'zh-cn';
					break;
				case 'en':
					this.disabledI18n = 'en';
					break;
				case 'zh-tw':
					this.disabledI18n = 'zh-tw';
					break;
			}
		},
		// 初始化全局组件大小
		initComponentSize() {
			switch (Local.get('themeConfigPrev').globalComponentSize) {
				case '':
					this.disabledSize = '';
					break;
				case 'medium':
					this.disabledSize = 'medium';
					break;
				case 'small':
					this.disabledSize = 'small';
					break;
				case 'mini':
					this.disabledSize = 'mini';
					break;
			}
		},
		// `dropdown 下拉菜单` 当前项点击
		onDropdownCommand(path) {
			if (path === 'logOut') {
				setTimeout(() => {
					this.$msgbox({
						closeOnClickModal: false,
						closeOnPressEscape: false,
						title: this.$t('message.user.logOutTitle'),
						message: this.$t('message.user.logOutMessage'),
						showCancelButton: true,
						confirmButtonText: this.$t('message.user.logOutConfirm'),
						cancelButtonText: this.$t('message.user.logOutCancel'),
						beforeClose: (action, instance, done) => {
							if (action === 'confirm') {
								instance.confirmButtonLoading = true;
								instance.confirmButtonText = this.$t('message.user.logOutExit');
								setTimeout(() => {
									done();
									setTimeout(() => {
										instance.confirmButtonLoading = false;
									}, 300);
								}, 700);
							} else {
								done();
							}
						},
					}).then(() => {
							// 清除缓存/token等
							Session.clear();
							// 使用 reload 时，不需要调用 resetRoute() 重置路由
							window.location.reload();
						})
						.catch(() => {});
				}, 150);
			} else if (path === 'wareHouse') {
				window.open('https://gitee.com/lyt-top/vue-next-admin');
			} else {
				this.$router.push(path);
			}
		},
	},
};
</script>

<style scoped lang="scss">
.layout-navbars-breadcrumb-user {
	display: flex;
	align-items: center;
	justify-content: flex-end;
	&-link {
		height: 100%;
		display: flex;
		align-items: center;
		white-space: nowrap;
		&-photo {
			width: 25px;
			height: 25px;
			border-radius: 100%;
		}
	}
	&-icon {
		padding: 0 10px;
		cursor: pointer;
		color: var(--prev-bg-topBarColor);
		height: 50px;
		line-height: 50px;
		display: flex;
		align-items: center;
		&:hover {
			background: var(--prev-color-hover);
			i {
				display: inline-block;
				animation: logoAnimation 0.3s ease-in-out;
			}
		}
	}
	& ::v-deep .el-dropdown {
		color: var(--prev-bg-topBarColor);
	}
	& ::v-deep .el-badge {
		height: 40px;
		line-height: 40px;
		display: flex;
		align-items: center;
	}
	& ::v-deep .el-badge__content.is-fixed {
		top: 12px;
	}
}
</style>
