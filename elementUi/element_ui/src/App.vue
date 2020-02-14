<template>
  <div id="app">
    <router-view v-if="isRouterActive"></router-view>

  </div>
</template>

<script>
export default {
  name: 'App',
  provide(){
    return{
      reload:this.reload
    };
  },
  data() {

    const item = {
      date: '2016-05-02',
      name: '王小虎',
      address: '上海市普陀区金沙江路 1518 弄'
    };
    return {
      isRouterActive:true,
      tableData: Array(20).fill(item)
    }
  },
  methods:{
    reload(){
      this.isRouterActive=false,
        this.$nextTick(function () {
          this.isRouterActive=true
        })
    }
  }
}
</script>

<style>
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }

  .el-aside {
    color: #333;
  }
</style>
