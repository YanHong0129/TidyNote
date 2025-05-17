<template>
  <div class="home">
    <h1>Welcome to the Note Taking App</h1>
    <p>This is a simple note-taking application built with Vue.js and Spring Boot.</p>
    <AddButton/>

    <div class="note-list">
      <h2>Your Notes</h2>
      <NoteList :notes="notes" @refresh="fetchNotes"/>
  </div>

  </div>
</template>

<script>
import NoteList from '../components/NoteList.vue';
import NoteService from '../services/NoteService.js';
import AddButton from '../components/AddButton.vue';
import AddNoteForm from './AddNoteForm.vue';

  export default {
    name: 'Home',
    components: {
      NoteList,
      AddButton,
      AddNoteForm
    },
    data() {
      return {
        notes: [],
      };
    },

    methods:{
      async fetchNotes() {
          this.notes = await NoteService.getNotes();
      },
    },

    mounted() { // Fetch notes on load
      this.fetchNotes();
    }
  }
</script>

<style scoped>

</style>