import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  catId: 0,
  basketCount: 0,
  cartId: undefined
};

export const mainStore = createSlice({
    name: "mainStore",
    initialState,
    reducers: {
        setCatId: (state, action) => {
          state.catId = action.payload;
        },
        incrementBasketCount: (state, action) => {
            state.basketCount = state.basketCount + 1;
        },
        setCartId: (state, action) => {
            state.cartId = action.payload;
        },
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

export const { setCatId, incrementBasketCount, setCartId, setProducts } = mainStore.actions;
export default mainStore.reducer;