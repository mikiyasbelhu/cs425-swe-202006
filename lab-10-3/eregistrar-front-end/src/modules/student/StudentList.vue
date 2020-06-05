<template>
  <div>
    <v-container
      fluid
      class="pb-0">
      <v-layout >
        <v-flex xs12>
          <div class="headline font-weight-thin">
            Students
          </div>
        </v-flex>
      </v-layout>
    </v-container>
    <v-container
      class="pt-2"
      fluid
      grid-list-lg>

      <v-layout wrap>
        <v-flex xs12 >
          <v-card class="pt-2">

            <v-toolbar
              flat
              color="white">
              <v-btn
                color="primary"
                class="pa-0 pl-2 pr-3"
                @click="$router.push({ name: 'student-create' })"
              >
                <v-icon class="mr-1">add_circle_outline</v-icon>
                New Student
              </v-btn>
              <v-spacer/>
              <v-flex
                xs12
                md4>
                <v-text-field
                  v-model="search"
                  label="Search"
                  single-line
                  append-icon="search"
                  solo
                />
              </v-flex>
            </v-toolbar>

            <v-data-table
              :headers="headers"
              :items="items"
              :pagination.sync="pagination"
              :total-items="totalItems"
              :loading="loading"
              rows-per-page-text="People per page"
            >
              <template
                slot="items"
                slot-scope="props">
                <tr
                  style="cursor: pointer"
                  @click="studentDetail(props.item)"
                >
                  <td>{{ props.item.studentNumber }}</td>
                  <td>{{ props.item.firstName }} {{ props.item.middleName }} {{ props.item.lastName }}</td>
                  <td>{{ props.item.cgpa }}</td>
                  
                  <td>{{ props.item.enrollmentDate }}</td>                  
                  <td @click.stop>
                    <v-menu
                      offset-x
                      left
                      bottom>
                      <v-btn
                        slot="activator"
                        icon>
                        <v-icon>more_vert</v-icon>
                      </v-btn>

                      <v-list dense >

                        <v-list-tile
                          ripple
                          @click="$router.push({name:'student-update',
                                                params:{studentId:props.item.studentId}})">
                          <v-list-tile-action>
                            <v-icon>edit</v-icon>
                          </v-list-tile-action>
                          <v-list-tile-title>Edit</v-list-tile-title>
                        </v-list-tile>
                        <v-list-tile
                          ripple
                          @click="deleteItem(props.item.studentId)">
                          <v-list-tile-action>
                            <v-icon>delete</v-icon>
                          </v-list-tile-action>
                          <v-list-tile-title>Delete</v-list-tile-title>
                        </v-list-tile>
                      </v-list>
                    </v-menu>
                  </td>
                </tr>
              </template>
            </v-data-table>
          </v-card>
        </v-flex>
      </v-layout>
    </v-container>
  </div>
</template>

<script>
import { StudentAPI } from "@/api";
import { tableMixin } from "@/shared/mixins";
import StudentDetail from "./StudentDetail.vue";

export default {
  name: "StudentList",
  mixins: [tableMixin],

  data() {
    return {
      resource: StudentAPI,
      resourceName: "Student",
      headers: [
        {
          text: "Student Number",
          value: "studentNumber"
        },
        {
          text: "Name",
          value: "name"
        },
        {
          text: "CGPA",
          value: "phoneNumber"
        },
        {
          text: "Enrollment Date",
          value: "date"
        },
        {
          text: "Actions",
          value: "actions",
          sortable: false
        }
      ]
    };
  },
  methods: {
    studentDetail(student) {
      this.$modal.show(
        StudentDetail,
        {
          modalName: "student-detail-modal",
          item: student
        },
        {
          name: "student-detail-modal",
          height: "auto",
          scrollable: true,
          width: 800
        }
      );
    }
  }
};
</script>

<style>
</style>
