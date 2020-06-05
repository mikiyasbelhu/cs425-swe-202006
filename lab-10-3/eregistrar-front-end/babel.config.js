module.exports = {
  presets: [
    [
      "@vue/app",
      {
        useBuiltIns: "entry"
      }
    ]
  ],
  plugins: [
    [
      "transform-imports",
      {
        vuetify: {
          // eslint-disable-next-line
          transform: "vuetify/es5/components/${member}",
          preventFullImport: true
        }
      }
    ]
  ]
};
