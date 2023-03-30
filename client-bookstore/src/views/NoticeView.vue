<template>
  <div class="w notice">
    <el-collapse>
      <el-collapse-item v-for="item in noticeInfo" :key="item.nid" :title="item.title" :name="item.nid">
        <div>
          {{item.content}}
        </div>
        <div>{{item.time}}</div>
      </el-collapse-item>
    </el-collapse>
  </div>
</template>

<script>
import { getNoticeInfoAPI } from "@/api/data";
export default {
  name: "noticeView",
  data() {
    return {
      noticeInfo: [],
    };
  },
  mounted() {
    this.getNoticeInfo();
  },
  methods: {
    async getNoticeInfo() {
      let res = await getNoticeInfoAPI();
      if(res.data.code == 200) {
        this.noticeInfo = res.data.data
        console.log(this.noticeInfo);
      }
    },
  },
};
</script>

<style>
</style>