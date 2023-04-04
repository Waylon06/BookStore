<template>
  <div class="w">
    <h1>订单页面</h1>
    <el-table :data="orders" style="width: 100%">
      <!-- <el-table-column prop="productImage" label="商品图片">
        <template slot-scope="scope">
          <el-image :src="scope.row.productImage" style="width: 80px; height: 80px;"></el-image>
        </template>
      </el-table-column> -->
      <el-table-column prop="oid" label="订单号"></el-table-column>
      <el-table-column prop="username" label="客户名称"></el-table-column>
      <!-- <el-table-column prop="totalAmount" label="总金额"></el-table-column> -->
      <el-table-column prop="ostatus" label="状态"></el-table-column>
       <el-table-column label="操作">
        <template slot-scope="{ row }">
          <el-button type="danger" size="small" @click="delOrder(row)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import { getFinishedOrderAPI, deleteOrderAPI } from "@/api/data";
export default {
  data() {
    return {
      orders: [
        {
          productImage: "https://via.placeholder.com/80x80",
          oid: "2019123456",
          username: "张三",
          totalAmount: 100,
          ostatus: "已完成",
        },
        {
          productImage: "https://via.placeholder.com/80x80",
          oid: "2019123457",
          username: "李四",
          totalAmount: 200,
          ostatus: "已完成",
        },
        {
          productImage: "https://via.placeholder.com/80x80",
          oid: "2019123458",
          username: "王五",
          totalAmount: 150,
          ostatus: "进行中",
        },
      ],
    };
  },
  mounted() {
    this.getFinishedOrder();
  },
  methods: {
    async getFinishedOrder() {
      let res = await getFinishedOrderAPI({
        uid: this.$store.state.userInfo.uid
      })
      console.log(res);
      if(res.data.code == 200) {
        this.orders = res.data.data
        this.orders.map(item => {
          item.username = this.$store.state.userInfo.username
          item.ostatus = item.ostatus == 0 ? '未完成' : '已完成'
        })
      }
    },
    async delOrder(order) {
    let res = await deleteOrderAPI({
      oid: order.oid
    })
    if(res.data.code == 200) {
      alert("删除成功！")
      this.$router.go(0);
    }
  }
  },
};
</script>
