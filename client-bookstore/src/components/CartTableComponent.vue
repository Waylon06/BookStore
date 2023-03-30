<template>
  <div class="container">
    <h1 class="title">购物车</h1>
    <el-table :data="cart" style="width: 100%" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="image" label="商品图片">
        <template slot-scope="{ row }">
          <img :src="row.cover" alt="" class="product-image" />
        </template>
      </el-table-column>
      <el-table-column prop="bname" label="商品名称"></el-table-column>
      <el-table-column prop="newPrice" label="单价"></el-table-column>
      <el-table-column label="数量">
        <template slot-scope="{ row }">
          <el-button
            @click="decrementNum(row)"
            type="text"
            icon="el-icon-minus"
          ></el-button>
          <span>{{ row.num }}</span>
          <el-button
            @click="incrementNum(row)"
            type="text"
            icon="el-icon-plus"
          ></el-button>
        </template>
      </el-table-column>
      <el-table-column prop="total" label="小计"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="{ row }">
          <el-button type="danger" size="small" @click="removeFromCart(row)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <div class="footer">
      <div class="total">总价：{{ total }}</div>
      <el-button type="primary" @click="checkout">结账</el-button>
    </div>
  </div>
</template>

<script>
import {getOrdersInfoAPI, deleteOrderAPI} from '@/api/data'
export default {
  data() {
    return {
      cart: [
        {
          bname: "商品1",
          newPrice: 10,
          num: 1,
          total: 10,
          image: "https://picsum.photos/id/1/200",
        },
        {
          bname: "商品2",
          newPrice: 20,
          num: 1,
          total: 20,
          image: "https://picsum.photos/id/2/200",
        },
        {
          bname: "商品3",
          newPrice: 30,
          num: 1,
          total: 30,
          image: "https://picsum.photos/id/3/200",
        },
      ],
      //被选中的数据
      multipleSelection: []
    };
  },
  mounted() {
    this.getOrdersInfo()
  },
  computed: {
    total() {
      let total = 0;
      for (const key in this.multipleSelection) {
        total += this.multipleSelection[key].newPrice*this.multipleSelection[key].num
      }
      return total
    },
  },
  methods: {
    async getOrdersInfo() {
      let res = await getOrdersInfoAPI({
        uid: this.$store.state.userInfo.uid
      })
      console.log(res);
      console.log(this.$store.state.userInfo.uid);
      if(res.data.code == 200) {
        this.cart = res.data.data
      }
    },
    async removeFromCart(product) {
      // const index = this.cart.indexOf(product);
      // this.cart.splice(index, 1);
      console.log(product.bid);
      let res = await deleteOrderAPI({
        uid: this.$store.state.userInfo.uid,
        bid: product.bid
      })
      if(res.data.code == 200) {
        alert('删除成功')
        this.$router.push(0);
      }
    },
    incrementNum(product) {
      product.num++;
      product.total = product.newPrice * product.num;
    },
    decrementNum(product) {
      if (product.num > 1) {
        product.num--;
        product.total = product.newPrice * product.num;
      }
    },
    checkout() {
      alert("结账成功！");
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    }
  },
};
</script>

<style lang="less" scoped>
.container {
  margin: 20px auto;
  width: 800px;
}

.title {
  text-align: center;
  font-size: 32px;
}

.product-image {
  width: 80px;
  height: 80px;
}

.footer {
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-top: 20px;
  padding: 10px 20px;
  background-color: #f2f2f2;
}

.total {
  font-size: 24px;
  font-weight: bold;
}
</style>
