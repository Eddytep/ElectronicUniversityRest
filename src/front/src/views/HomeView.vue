<template>
  <v-container>
    <v-row>
      <v-col>
        <h2 class="text-center py-3">Welcome to Electronic University</h2>
        <v-carousel cycle interval=3000 hide-delimiters show-arrows-on-hover>
          <v-carousel-item
              v-for="(item,i) in items"
              :key="i"
              :src="item.src"
              eager
          ></v-carousel-item>
        </v-carousel>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'HomeView',
  data() {
    return {
      userProfile: '',
      items: [
        {
          src: '/static/content/image1.jpg',
        },
        {
          src: '/static/content/image2.jpg',
        },
        {
          src: '/static/content/image3.png',
        },
      ]
    }
  }
}
</script>
