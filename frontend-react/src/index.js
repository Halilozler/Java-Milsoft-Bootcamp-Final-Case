import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import { Provider } from 'react-redux';
import Router from './Router';
import store from './store/index'
import style from './style/index.js'
import { NotificationContainer } from 'react-notifications';
import 'react-notifications/lib/notifications.css';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <Provider store={store}>
    <Router />
    <NotificationContainer/>
  </Provider>
);
