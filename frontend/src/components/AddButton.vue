<template>
    <div>
        <button class="add-button"  @click="AddNotePage">
            +
        </button>
    </div>
</template>

<script>
    export default {
        name: 'AddButton',
        methods: {
            AddNotePage() {
                this.$router.push({ name: 'AddNoteForm' });
            }
        }
    }
</script>

<style scoped>
    .add-button {
    position: fixed;
    bottom: 50px;
    right: 50px;

    background-color: #4CAF50;
    color: white;
    border: none;
    padding: 18px 26px;
    text-align: center;
    font-size: 25px;
    border-radius: 10px;
    box-shadow: 0 2px 6px rgba(0, 0, 0, 0.2);
    cursor: pointer;
    transition: background-color 0.3s ease;
    }
</style>