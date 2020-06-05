<template>
  <v-layout
    justify-center
    row
    wrap
  >
    <v-flex xs11>
      <v-form @submit.prevent="save">
        <v-toolbar
          dense
          class="grey lighten-4 elevation-2 mb-1"
        >
          <v-tooltip bottom>
            <v-btn
              slot="activator"
              icon
              @click="$router.push({ name: 'student-list' })">
              <v-icon>arrow_back</v-icon>
            </v-btn>
            <span>Cancel</span>
          </v-tooltip>
          <v-toolbar-title
            class="blue-grey--text text--darken-2 font-weight-bold"
          >
            Add Student
          </v-toolbar-title>
          <v-spacer/>
          <v-btn
            color="primary"
            type="submit"
          >
            Save
          </v-btn>
        </v-toolbar>

        <v-card
          tile
          class="grey lighten-5 pa-3"
        >
          <form-error-messages
            :messages="errorMessage" />

          <!-- row 1 -->
          <v-layout row>
            <v-flex xs4>
              <v-text-field
                v-validate="'required'"
                v-model="item.firstName"
                :error-messages="errors.collect('firstName')"
                label="First Name"
                name="firstName"
                box
                background-color="white elevation-1"
              />
            </v-flex>
            <v-flex 
              xs4 
              pl-3>
              <v-text-field
                v-model="item.middleName"
                :error-messages="errors.collect('middleName')"
                label="Middle Name"
                name="middleName"
                box
                background-color="white elevation-1"
              />
            </v-flex>
            <v-flex 
              xs4 
              pl-3>
              <v-text-field
                v-validate="'required'"
                v-model="item.lastName"
                :error-messages="errors.collect('lastName')"
                label="Last Name"
                name="lastName"
                box
                background-color="white elevation-1"
              />
            </v-flex>
          </v-layout>
          <v-layout row>
            <v-flex xs4>
              <v-text-field
                v-validate="'required'"
                v-model="item.studentNumber"
                :error-messages="errors.collect('studentNumber')"
                label="Student Number"
                name="studentNumber"
                box
                background-color="white elevation-1"
              />
            </v-flex>
            <v-flex
              xs4
              pl-3
            >
              <v-text-field
                v-model="item.cgpa"
                :error-messages="errors.collect('cgpa')"
                label="CGPA"
                name="cgpa"
                type="number"
                box
                background-color="white elevation-1"
              />
            </v-flex>
            <v-flex 
              pl-3 
              xs4>
              <v-menu 
                :close-on-content-click="false" 
                v-model="enrollmentDateMenu" 
                :nudge-right="40" 
                lazy 
                transition="scale-transition" 
                offset-y 
                full-width 
                min-width="290px">
                <v-text-field 
                  v-validate="'required'"
                  slot="activator" 
                  :error-messages="errors.collect('enrollment date')" 
                  v-model="item.enrollmentDate" 
                  name="enrollment date" 
                  label="Enrollment Date" 
                  readonly 
                  background-color="white elevation-1"
                  outline />
                <v-date-picker 
                  v-model="item.enrollmentDate" 
                  @input="enrollmentDateMenu=false" />
              </v-menu>
            </v-flex>
          </v-layout>
        </v-card>
      </v-form>
    </v-flex>
  </v-layout>
</template>

<script>
import { StudentAPI } from "@/api";

export default {
  name: "StudentCreate",
  data() {
    return {
      errorMessage: null,
      enrollmentDateMenu: false,
      enrollmentDate: null,
      item: {}
    };
  },
  methods: {
    save() {
      this.$validator.validateAll().then(valid => {
        if (valid) {
          this.errorMessage = null;
          StudentAPI.create(this.item)
            .then(() => {
              this.item = {};
              this.$notify({
                type: "success",
                title: "Success",
                message: "Student created successfully"
              });
              this.$router.push({ name: "student-list" });
            })
            .catch(err => {
              if (err.statusCode === 422) {
                const { messages } = err.details;
                this.errorMessage = messages;
              }
            });
        }
      });
    }
  }
};
</script>
