import React from 'react';
import {
  Platform,
  StyleSheet,
  View,
  Text,
  Image,
  TouchableOpacity,
  Alert,
  SafeAreaView,
} from 'react-native';

import SearchableFlatList from './MainApps';

const App = () => (
  <SafeAreaView style={{flex: 1, backgroundColor: '#2c2c2c'}}>
    <SearchableFlatList />
  </SafeAreaView>
);

export default App;
