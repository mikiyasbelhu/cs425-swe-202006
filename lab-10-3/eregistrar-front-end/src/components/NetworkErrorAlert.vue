<template>
  <span data-notify="message">
    <span class="title">
      <b class="notify-error-title">Network Error<br></b>
    </span>
    <span class="notify-error-body">Can not connect to the server</span>
  </span>
</template>

<script>
export default {
  name: "NotificationTemplate"
};
</script>

<style>
.notify-error-title {
  color: #9c2f07;
  font-size: 0.7em;
  text-transform: uppercase;
}
.notify-error-body {
  color: #9c2f07 !important;
  line-height: 1.5em;
}
</style>
