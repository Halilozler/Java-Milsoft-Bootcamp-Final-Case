import { configureStore } from "@reduxjs/toolkit";
import mainStore from './mainstore';

const store = configureStore({
    reducer: {
        // Add your reducers here
        mainStore
    },
});

export default store;