<template>
    <div class="upload-form">
        <h1>{{ (view==='add') ? 'Add New Note' : 'Edit Note' }}</h1>
        <form @submit.prevent="submitForm">
            <input type="text" v-model="note.title" placeholder="Title" required />
            <textarea v-model="note.content" placeholder="Content" required></textarea>
            
            <button type="submit">{{ (view==='add') ? 'Save' : 'Save Changes' }}</button>
            <button type="button" @click="cancel">Cancel</button>
        </form>
    </div>
</template>

<script>
import { watch } from 'vue';
import NoteService from '../services/NoteService.js';

    export default {
        name: 'AddNoteForm',

        data() {
            return {
                view: '',
                noteID: '',        
                note: {
                    id: null,
                    title: '',
                    content: ''
                }
            };
        },

        methods: {
            cancel() {
                this.$router.push('/');
            },

            async submitForm(){
                if(this.view === 'add'){
                    try {
                        await NoteService.addNote(this.note);
                        this.$emit('refresh');
                        this.$router.push('/');
                    } catch (error) {
                        console.error('Failed to add note:', error);
                        alert('Failed to add note. Please try again.');
                    }
                } else {
                    try {
                        await NoteService.updateNote(this.note.id, this.note);
                        this.$emit('refresh');
                        this.$router.push('/');
                    } catch (error) {
                        console.error('Failed to update note:', error);
                        alert('Failed to update note. Please try again.');
                    }
                }
            },

            async initializeData() {
                this.view = this.$route.meta.view || 'add';
                this.noteID = this.$route.params.noteID;

                if (this.view === 'edit') {
                    try {
                        const note = await NoteService.getNoteById(this.noteID);

                        this.note = {
                            id: note.id,
                            title: note.title,
                            content: note.content
                        };
                        } catch (error) {
                        console.error('Failed to fetch note:', error);
                        alert('Failed to fetch note. Please try again.');
                        }
                }
                },
    },
    
    created() {
            this.initializeData();
    },

    watch:{
        '$route'(){
            this.initializeData();
        }
    },
    }
</script>

<style scoped>
    .form-container {
    background: #f9f9f9;
    padding: 16px;
    border-radius: 8px;
    margin-top: 1rem;
    }
    input,
    textarea {
    width: 100%;
    margin-bottom: 10px;
    padding: 8px;
    }
    button {
    margin-right: 10px;
    padding: 6px 12px;
    }
</style>