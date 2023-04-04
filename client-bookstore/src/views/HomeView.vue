<template>
  <div class="index-page">
    <div class="main-box">
      <!-- Swiper轮播图 -->
      <div class="swiper-container">
        <div class="swiper-wrapper">
          <div class="swiper-slide">
            <img src="@/assets/img/slide/slide_2.png" />
          </div>
          <div class="swiper-slide">
            <img src="@/assets/img/slide/slide_1.jpg" />
          </div>
          <div class="swiper-slide">
            <img src="@/assets/img/slide/slide_4.png" />
          </div>
        </div>
        <!-- Add Pagination -->
        <div class="swiper-pagination"></div>
      </div>
      <!-- 搜索框 -->
      <div class="search">
        <div class="search-box">
          <div class="ipt-box">
            <select name="search-name" class="select-box">
              <option value="0">全部</option>
              <option value="1">外国文学</option>
              <option value="2">历史传记</option>
              <option value="3">华文小说</option>
            </select>
            <input type="text" class="ipt" placeholder="请输入你的搜索内容" v-model="bookName"/>
            <button class="btn" @click="clickToSearch">
              <i></i>
              <span >搜索</span>
            </button>
          </div>
        </div>
      </div>
    </div>
    <!-- 书籍信息 -->
    <div class="discount w">
      <div class="sale-pic">
        <img src="@/assets/img/discount.png" />
      </div>
      <ul class="goods">
        <li class="goods_info" v-for="item in booksInfo" :key="item.bid">
          <div class="goods_pic_wrap">
            <img :src="imgUrl + item.cover" />
          </div>
          <div class="goods_details">
            <div class="goods_title">{{item.title}}</div>
            <div class="price">
              <div class="now_price">￥{{item.newPrice}}</div>
              <div class="old_price"><del>￥{{item.oldPrice}}</del></div>
            </div>
          </div>
          <button class="btn" @click="toOrder(item.bid)">加入购物车</button>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import Swiper from "swiper";
// import 'swiper/css/swiper.min.css';
import {getBooksInfoAPI,getBookByNameAPI,clickToOrderAPI} from '@/api/data'
export default {
  components: {
    Swiper,
  },
  data() {
    return {
      booksInfo: [],
      bookName: ''
    };
  },
  mounted() {
    new Swiper(".swiper-container", {
      speed: 3000,
      loop: true,
      spaceBetween: 30,
      centeredSlides: true,
      autoplay: {
        delay: 2500,
        disableOnInteraction: false,
      },
      pagination: {
        el: ".swiper-pagination",
        clickable: true,
      },
      // navigation: {
      //   nextEl: ".swiper-button-next",
      //   prevEl: ".swiper-button-prev",
      // },
    });
    this.getBooksInfo();
  },
  methods: {
    async getBooksInfo() {
      let res = await getBooksInfoAPI();
      console.log(res);
      if(res.data.code == 200) {
        this.booksInfo = res.data.data;
        console.log(this.booksInfo);
      }
    },
    async clickToSearch() {
      if(this.bookName == '') {
        this.getBooksInfo();
      }else {
        let res = await getBookByNameAPI({
        bname: this.bookName
      })
      if(res.data.code == 200) {
        this.booksInfo = res.data.data;
        console.log(this.booksInfo);
      }
      }
    },
    async toOrder(bid) {
      let res = await clickToOrderAPI({
        bid: bid,
        uid: this.$store.state.userInfo.uid
      })
      if(res.data.code == 200) {
        alert('添加成功')
        this.$router.push('/cart')
      }
    }
  }
};
</script>

<style lang="less" scoped>
.main-box {
  position: relative;
  height: 750px;
  .search {
    position: absolute;
    top: 20%;
    right: 0;
    left: 0;
    padding: 40px 80px 0 80px;
    z-index: 999;
    .search-box {
      width: 803px;
      height: 162px;
      font-size: 0;
      box-sizing: border-box;
      border-top: 6px solid #415285;
      background: rgba(255, 255, 255, 0.7);
      border-radius: 0px 6px 6px 6px;
      padding: 35px 50px;
      margin: 0 auto;
      .ipt-box {
        width: 100%;
        height: 50px;
        border: 1px solid rgba(65, 82, 133, 0.5);
        border-radius: 6px;
        .select-box {
          border: none;
          width: 128px;
          height: 50px;
          background: rgba(65, 82, 133, 0.05);
          border-right: 1px solid rgba(65, 82, 133, 0.5);
          float: left;
          text-align: center;
          font-size: 16px;
        }
        .ipt {
          line-height: 50px;
          height: 50px;
          padding: 0 20px;
          font-size: 16px;
          border-radius: 6px;
          float: left;
          border: none;
          width: 425px;
          background: rgba(255, 255, 255, 0.7);
        }
        .btn {
          background: #3d82f2;
          border: none;
          outline: none;
          width: 110px;
          height: 50px;
          border-radius: 0px 6px 6px 0px;
          font-size: 18px;
          color: #ffffff;
          float: right;
        }
      }
    }
  }
}
.swiper-container {
  position: absolute;
  height: 700px;
  width: 100%;
  .swiper-wrapper img {
    height: 100%;
    width: 100%;
    // 保持原有尺寸比例，使图片的宽度完整的显示，高度自动缩放。
    object-fit: contain;
    // 保持原有尺寸比例。高度铺满容器，宽度等比缩放，超出部分被剪掉。
    // object-fit: cover;
    margin-bottom: 20px;
  }
  .discount {
    position: absolute;
  }
}

.goods {
  .goods_info {
    display: inline-block;
    .goods_pic_wrap {
      height: 240px;
      width: 182px;
      padding: 0 18px 0 0;
      img {
        margin: 0 auto;
        height: 100%;
        width: 100%;
      }
    }
    .goods_details {
      .goods_title {
        font-size: 12px;
        text-align: left;
        padding: 0 18px;
        width: 154px;
        height: 33px;
      }
      .price {
        padding: 12px 18px;
        width: 154px;
        height: 27px;
        text-align: left;
        .now_price {
          color: #f0250f;
          display: inline-block;
          font-size: 18px;
          text-align: left;
          margin-right: 5px;
        }
        .old_price {
          display: inline-block;
          font-size: 12px;
        }
      }
    }
    .btn {
      height: 30px;
      width: 160px;
      margin-right: 18px;
      color: #ffffff;
      font-size: 15px;
      background-color: #3d82f2;
      border: none;
      border-radius: 15px;
      // padding-bottom: 12px;
      margin-bottom: 12px;
      cursor: pointer;
    }
  }
}
</style>