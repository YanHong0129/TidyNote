import axios from "axios";

const API_BASE_URL = "/api/notes";

export default {
    async getNotes() {
        try {
        const response = await axios.get(API_BASE_URL);
        return response.data;
        } catch (error) {
        console.error("Error fetching notes:", error);
        throw error;
        }
    },

    async addNote(note) {
        try {
        const response = await axios.post(API_BASE_URL, note);
        return response.data;
        } catch (error) {
        console.error("Error adding note:", error);
        throw error;
        }
    },

    async deleteNote(noteID) {
        try {
        const response = await axios.delete(`${API_BASE_URL}/${noteID}`);
        return response.data;
        } catch (error) {
        console.error("Error deleting note:", error);
        throw error;
        }
    },

    async updateNote(noteID, updatedNote) {
        try {
        const response = await axios.put(`${API_BASE_URL}/${noteID}`, updatedNote);
        return response.data;
        } catch (error) {
        console.error("Error updating note:", error);
        throw error;
        }
    },

    async getNoteById(noteID) {
        try {
        const response = await axios.get(`${API_BASE_URL}/${noteID}`);
        return response.data;
        } catch (error) {
        console.error("Error fetching note by ID:", error);
        throw error;
        }
    }
}