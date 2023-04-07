import { createSlice } from "@reduxjs/toolkit";

const initialState = {

};

export const mainStore = createSlice({
    name: "mainStore",
    initialState,
    reducers: {
        /*
        increment: (state, action) => {
            state.num = state.num++;
            console.log(state.num);
          },
          setNum: (state, action) => {
            state.num = action.payload.num
          },
          getNum: (state, action) => {
              console.log(state.num);
          },
          */
    },
});

export const { increment, setNum, getNum } = mainStore.actions;
export default mainStore.reducer;