import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import { getProfileInformation } from "../utils/ApiCommand";

const initialState = {
  isAuthenticated: false,
  username: "",
  email: "",
  totalPrice: 0,
  catId: 0,
  basketCount: 0,
  cartId: undefined
};

// Async işlem
export const fetchUser = createAsyncThunk("mainStore/fetchUser", async () => {
  const response = await getProfileInformation();
  return response.data;
});

export const mainStore = createSlice({
    name: "mainStore",
    initialState,
    reducers: {
        setCatId: (state, action) => {
          state.catId = action.payload;
        },
        incrementBasketCount: (state, action) => {
            if(action.payload === undefined){
              state.basketCount = state.basketCount + 1;
            }else{
              state.basketCount = action.payload;
            }
            
        },
        setCartId: (state, action) => {
            state.cartId = action.payload;
        },
        setLogin: (state, action) => {
          state.isAuthenticated = true;
          state.user = action.payload;
        },
        setLogout: (state) => {
          state.isAuthenticated = false;
          state.user = null;
        },
        setTotalPriceGlobal: (state, action) => {
          state.totalPrice = action.payload;
        }
      },
        extraReducers: (builder) => {
          builder.addCase(fetchUser.fulfilled, (state, action) => {
            state.username = action.payload.username;
            state.email = action.payload.email;
            state.basketCount = action.payload.basketItemCount;
          });
    },
});

export const { setCatId, incrementBasketCount, setCartId, setLogin, setLogout, setTotalPriceGlobal } = mainStore.actions;
export default mainStore.reducer;