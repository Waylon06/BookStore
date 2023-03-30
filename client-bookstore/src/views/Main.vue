<template>
  <el-container>
    <el-header style="padding: 0; background-color: #567487;">
      <nav-component/>
    </el-header>
    <el-main>
      <router-view></router-view>
    </el-main>
  </el-container>
</template>

<script>
import navComponent from '@/components/NavComponent'
export default {
  name: 'Main',
  components: {
    navComponent,
  }
};
</script>

<style lang="less" scoped>
.el-main {
  padding: 0;
}
</style>