<template>
  <div class="w">
    <h1>订单页面</h1>
    <el-table :data="orders" style="width: 100%">
      <!-- <el-table-column prop="productImage" label="商品图片">
        <template slot-scope="scope">
          <el-image :src="scope.row.productImage" style="width: 80px; height: 80px;"></el-image>
        </template>
      </el-table-column> -->
      <el-table-column prop="orderNumber" label="订单号"></el-table-column>
      <el-table-column prop="customerName" label="客户名称"></el-table-column>
      <el-table-column prop="totalAmount" label="总金额"></el-table-column>
      <el-table-column prop="status" label="状态"></el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      orders: [
        {
          productImage: 'https://via.placeholder.com/80x80',
          orderNumber: '2019123456',
          customerName: '张三',
          totalAmount: 100,
          status: '已完成',
        },
        {
          productImage: 'https://via.placeholder.com/80x80',
          orderNumber: '2019123457',
          customerName: '李四',
          totalAmount: 200,
          status: '已完成',
        },
        {
          productImage: 'https://via.placeholder.com/80x80',
          orderNumber: '2019123458',
          customerName: '王五',
          totalAmount: 150,
          status: '进行中',
        },
      ],
    };
  },
};
</script>
