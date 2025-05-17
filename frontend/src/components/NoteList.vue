<template>
  <div class="note-list-container">
    <table class="note-table">
      <thead>
        <tr>
          <th>Title</th>
          <th>Content</th>
          <th class="actions-header">Actions</th>
        </tr>
      </thead>
      <tbody>
        <NoteItem
          v-for="note in notes"
          :key="note.id"
          :note="note"
          @refresh="$emit('refresh')"
          />
      </tbody>
    </table>
  </div>
</template>

<script>
import NoteItem from './NoteItem.vue';

export default {
  name: 'NoteList',
  components: {
    NoteItem
  },
  props: {
    notes: {
      type: Array,
      required: true
    }
  }
}
</script>

<style scoped>
.note-list-container {
  width: 100%;
  overflow-x: auto;
  margin-top: 1rem;
}
.note-table {
  width: 100%;
  border-collapse: collapse;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
}
.note-table th,
.note-table td {
  padding: 12px 16px;
  border-bottom: 1px solid #e0e0e0;
  text-align: left;
}
.actions-header {
  text-align: right;
}
</style>
