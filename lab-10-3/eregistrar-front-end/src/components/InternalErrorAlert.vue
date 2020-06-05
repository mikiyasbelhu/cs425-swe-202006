<template>
  <span data-notify="message">
    <span class="title">
      <b class="notify-error-title">Internal Error<br></b>
    </span>
    <span class="notify-error-body">Something went wrong in our side.</span>
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
}
.notify-error-body {
  color: #9c2f07 !important;
  line-height: 1.5em;
}
</style>
