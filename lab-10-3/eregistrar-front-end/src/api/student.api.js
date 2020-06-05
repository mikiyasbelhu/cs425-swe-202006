import { API_ROOT } from ".";
import Request from "./request";

const PATH = "/student";

const StudentAPI = {
  get(id) {
    return Request.get(`${API_ROOT}${PATH}/get/${id}`);
  },
  all() {
    return Request.get(`${API_ROOT}${PATH}/list`);
  },
  create(data) {
    return Request.post(`${API_ROOT}${PATH}/register`, data);
  },
  update(data) {
    return Request.put(`${API_ROOT}${PATH}/edit/${data.studentId}`, data);
  },
  remove(id) {
    return Request.delete(`${API_ROOT}${PATH}/delete/${id}`);
  }
};

export default StudentAPI;
