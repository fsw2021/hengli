<template>
  <div class="app-container home">
    <el-row :gutter="20" style="margin-bottom:0.5rem">
      <el-col :sm="24" :lg="24">
        <div class="headName">恒立数控智能运维云平台</div>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :sm="24" :lg="24">
        <el-card class="update-log">
          <div class="block">
            <el-carousel height="242px">
              <el-carousel-item v-for="item in bgimg" :key="item.url">
                <img :src="item.url" alt="" class="bgimg" />
              </el-carousel-item>
            </el-carousel>
          </div>
        </el-card>
      </el-col>
    </el-row>
    <el-divider />
    <el-row :gutter="20" style="margin-bottom:0.5rem">
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>恒立工厂</span>
          </div>
          <div class="block">
            <el-row :gutter="10">
              <el-col
                :span="12"
                v-for="(o, index) in 2"
                :key="o"
              >
                <el-card :body-style="{ padding: '0px' }">
                  <el-image
                    :src="factoryImg[index].url"
                    style="height: 200px;"
                  />
                  <div style="padding: 14px;">
                    <span>{{ factoryImg[index].name }}</span>
                  </div>
                </el-card>
              </el-col>
            </el-row>
          </div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>公司简介</span>
          </div>
          <div class="block" style="display: flex;">
            <div style="line-height: 25px;margin-left:0.6rem">
              <p>浙江恒立数控科技股份有限公司是致力于为全球高端客户提供金属板材落料、剪切成套装备的中国企业。SUMIKURA(住仓)是浙江恒立控股的日本企业。浙江恒立公司位于浙江省德清高新开发区。公司是国家重点扶持的高新技术企业、国家火炬计划重点企业。公司是金属板材落料、剪切成套装备国家标准和行业标准的制定、起草单位之一。</p>
              <p>公司产品涵盖汽车板钢、铝板、镀锡板、硅钢领域。汽车板钢（铝）落料线、摆剪、飞剪、纵剪，波剪，多工位全套金属板材成形设备。其主导产品为上海宝钢、首钢、中粤浦项制铁、吉利汽车、东风汽车、西南铝、中铝、日本神钢、真钢等特大型企业所选用，并已出口德国、意大利、美国，也是中国大陆唯一进入日本本土金属板材成型设备机电设备的企业。</p>
            </div>
          </div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>平台简介</span>
          </div>
          <div class="block">
            <el-timeline :reverse="reverse">
              <el-timeline-item
                v-for="(activity, index) in activities"
                :key="index"
                :timestamp="activity.timestamp"
              >
                {{ activity.content }}
              </el-timeline-item>
            </el-timeline>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "3.7.0",
      bgimg: [
        { url: require("../assets/images/bgimg1.jpg") },
        { url: require("../assets/images/bgimg2.jpg") },
        { url: require("../assets/images/bgimg3.jpg") },
        { url: require("../assets/images/bgimg4.jpg") },
        { url: require("../assets/images/bgimg5.jpg") },
        { url: require("../assets/images/bgimg6.jpg") },
        { url: require("../assets/images/bgimg7.jpg") }
      ],
      reverse: true,
      activities: [
        {
          content: "系统管理",
          timestamp: "用户、部门、菜单管理"
        },
        {
          content: "生产任务管理",
          timestamp: "原材与成品管理"
        },
        {
          content: "产线管理",
          timestamp: "产线基本信息"
        },
        {
          content: "产线监控",
          timestamp: "实时监控产线状态"
        },
      ],
      factoryImg: [
        {
          name: '日本滨松工厂',
          url: require("../assets/images/factory1.jpg")
        },
        {
          name: '中国德清工厂',
          url: require("../assets/images/factory2.jpg")
        },
      ]
    };
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },
  },
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }

  .headName {
    text-align: center;
    font-size: 20px;
    font-weight: 900;
    color: #409eff;
  }
}
</style>

