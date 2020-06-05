import StudentList from "./StudentList.vue";
import StudentCreate from "./StudentCreate.vue";
import StudentUpdate from "./StudentUpdate.vue";

export default [
  {
    path: "students",
    name: "student-list",
    component: StudentList,
    meta: {
      allowedUserRoles: ["Administrator"]
    }
  },
  {
    path: "students/new",
    name: "student-create",
    component: StudentCreate,
    meta: {
      allowedUserRoles: ["Administrator"]
    }
  },
  {
    path: "students/:studentId/update",
    name: "student-update",
    component: StudentUpdate,
    meta: {
      allowedUserRoles: ["Administrator"]
    }
  }
];
