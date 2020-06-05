const buildFilter = pagination => {
  if (!pagination) return {};
  const { sortBy, descending, page, rowsPerPage } = pagination;
  const skip = page === 1 ? 0 : (page - 1) * rowsPerPage;
  const filter = {};
  if (skip >= 0) {
    filter.skip = skip;
  }
  if (rowsPerPage && rowsPerPage > 0) {
    filter.limit = rowsPerPage;
  }
  if (sortBy) {
    filter.order = `${sortBy} ${descending ? "DESC" : "ASC"}`;
  }
  return filter;
};
const buildSearchFilter = (prop, query) => ({
  where: { [prop]: { like: `.*${query}.*`, options: "i" } }
});

const zeroPad = num => (num >= 10 ? num : `0${num}`);
// eslint-disable-next-line
export { buildSearchFilter,buildFilter, zeroPad };
