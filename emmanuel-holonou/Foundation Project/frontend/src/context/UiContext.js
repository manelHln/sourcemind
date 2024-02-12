import { createContext, useReducer } from "react";

const INITIAL_STATE = {};

const uiContext = createContext(INITIAL_STATE);

const uiReducer = (state, action) => {
  const { type, payload } = action;
  switch (type) {
    case "toggle_sidebar":
      return 1;
  }
};

export const uiProvider = ({ children }) => {
  const [state, dispatch] = useReducer(uiReducer, INITIAL_STATE);

  const value = {}

  return <uiContext.Provider value={value}>{children}</uiContext.Provider>;
};
