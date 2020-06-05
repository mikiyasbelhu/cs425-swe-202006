// import { buildFilter } from "@/util";

const debounce = require("lodash.debounce");

const tableMixin = {
  watch: {
    pagination: {
      handler() {
        this.loadData();
      },
      deep: true
    },
    search() {
      this.doSearch();
    }
  },
  data() {
    return {
      searchable: true,
      totalItems: 0,
      items: [],
      loading: true,
      pagination: { skip: 0, rowsPerPage: 10 },
      search: ""
    };
  },
  methods: {
    doSearch: debounce(async function s() {
      if (this.search) {
        this.loading = true;
        const { rows, count } = await this.resource.search(this.search);
        this.items = rows;
        this.totalItems = count;
        this.loading = false;
      } else {
        this.loadData();
      }
    }, 500),
    async deleteItem(id) {
      const confirmed = await this.$confirm("Are you sure?");
      if (confirmed) {
        await this.resource.remove(id);
        this.$notify({
          type: "success",
          title: "Success",
          message: `${this.resourceName} deleted successfully`
        });
        this.loadData();
      }
    },
    async loadData() {
      this.loading = true;
      // const filters = {
      //   ...instantFilters,
      //   ...this.filter,
      //   ...buildFilter(this.pagination)
      // };

      const rows = await this.resource.all();
      this.items = rows;
      this.totalItems = rows.length;
      this.loading = false;
    }
  }
};
export default tableMixin;
