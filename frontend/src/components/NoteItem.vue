<template>
    <tr>
          <td>{{ note.title }}</td>
          <td>{{ note.content }}</td>
          <td class="note-actions">
            <button class="edit-btn" @click="updateNote">Edit</button>
            <button class="delete-btn" @click="deleteNode">Delete</button>
          </td>
    </tr>
</template>

<script>
    import NoteService from '../services/NoteService.js';
    export default {
        name: 'NoteItem',
        props: {
            note: {
                type: Object,
                required: true
            }
        },

        methods: {
            updateNote() {
                this.$router.push({ name: 'EditNoteForm', params: { noteID: this.note.id } });
            },
            async deleteNode() {
            try {
                await NoteService.deleteNote(this.note.id);
                this.$emit('refresh');
            } catch (error) {
                console.error('Failed to delete note:', error);
                alert('Failed to delete note. Please try again.');
            }
            }
            
        }

    }


</script>

<style scoped>
    .note {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 10px;
    border-bottom: 1px solid #ccc;
    list-style: none;
     }

    .note-actions {
    display: flex;
    gap: 10px;
    }

    .note-actions button {
    padding: 5px 10px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    }

    tr {
    text-align: left;
    }
    

</style>