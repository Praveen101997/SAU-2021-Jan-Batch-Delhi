import React from 'react';
import {
  Linking,
  Alert,
  FlatList,
  StyleSheet,
  View,
  Text,
  Button,
  Image,
  ActivityIndicator,
  TextInput,
} from 'react-native';
import {createAppContainer} from 'react-navigation';
import {createStackNavigator} from 'react-navigation-stack';
import {ListItem, SearchBar, Avatar} from 'react-native-elements';
// import {Icon} from 'react-native-elements';
// import {IconButton, Colors} from 'react-native-paper';
import {ScrollView, TouchableOpacity} from 'react-native-gesture-handler';

//==========================================================================

class HomeScreen extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      isLoading: true,
      page: 1,
      paginationloading: false,
    };

    this.arrayholder = [];
    this.LoadRandomData = this.LoadRandomData.bind(this);
    this.LoadMoreRandomData = this.LoadMoreRandomData.bind(this);
  }

  componentDidMount() {
    return this.LoadRandomData();
  }

  LoadRandomData = () => {
    fetch('https://randomuser.me/api/?results=10&page=${this.state.page}')
      .then((response) => response.json())
      .then((responseJson) => {
        this.arrayholder = [...this.arrayholder, ...responseJson.results];
        this.setState(
          {
            isLoading: false,
            dataSource: this.arrayholder,
            paginationloading: false,
          },
          function () {},
        );
      })
      .catch((error) => {
        console.error(error);
      });
  };

  LoadMoreRandomData = () => {
    this.setState(
      {
        paginationloading: true,
        page: this.state.page + 1,
      },
      () => this.LoadRandomData(),
    );
  };

  renderSeparator = () => {
    return (
      <View style={{height: 1, width: '100%', backgroundColor: '#2c2c2c'}} />
    );
  };

  searchFilterFunction = (text) => {
    this.setState({
      value: text,
    });

    const newData = this.arrayholder.filter((item) => {
      const itemData = `${item.name.title.toUpperCase()} ${item.name.first.toUpperCase()} ${item.name.last.toUpperCase()}`;
      const textData = text.toUpperCase();

      return itemData.indexOf(textData) > -1;
    });
    this.setState({
      dataSource: newData,
    });
  };

  sortFlatFunc = () => {
    const newData = this.arrayholder.sort((a, b) =>
      a.gender.localeCompare(b.gender),
    );
    this.setState({
      dataSource: newData,
    });
  };

  closeSearchFunc = () => {
    this.setState({
      value: '',
      dataSource: this.arrayholder,
    });
  };

  renderFooterLoading = () => {
    return (
      <View style={{flex: 1, paddingTop: 20}}>
        <ActivityIndicator size="large" color="#0000ff" />
      </View>
    );
  };

  renderHeader = () => {
    return (
      <View style={styles.row}>
        <View style={styles.inputWrap}>
          <TextInput
            style={styles.inputsearch}
            onChangeText={(text) => this.searchFilterFunction(text)}
            autoCorrect={false}
            placeholder="Search Name"
            value={this.state.value}
          />
        </View>

        <View>
          <TouchableOpacity
            style={styles.SubmitButtonStyle}
            activeOpacity={0.5}
            onPress={this.closeSearchFunc}>
            <Text style={styles.tStyle}> X </Text>
          </TouchableOpacity>
        </View>

        <View>
          <TouchableOpacity
            style={styles.SubmitButtonStyle}
            activeOpacity={0.5}
            onPress={this.sortFlatFunc}>
            <Text style={styles.tStyle}> S </Text>
          </TouchableOpacity>
        </View>
      </View>
    );
  };

  // For footer more loading items insteads of auto rendering
  // renderFooter = () => {
  //   if (this.state.paginationloading) {
  //     return <ActivityIndicator size="large" color="white" style={{}} />;
  //   } else {
  //     return (
  //       //Footer View with Load More button
  //       <View style={styles.footer}>
  //         <TouchableOpacity
  //           activeOpacity={0.9}
  //           onPress={this.LoadMoreRandomData}
  //           style={styles.loadMoreBtn}>
  //           <Text style={styles.btnText}>Load More</Text>
  //         </TouchableOpacity>
  //       </View>
  //     );
  //   }
  // };

  render() {
    let Splash_Screen = (
      <View style={styles.SplashScreen_RootView}>
        <View style={styles.SplashScreen_ChildView}>
          <Text style={{fontSize: 40, fontWeight: 'bold', color: '#5dfc75'}}>
            Person Details
          </Text>
        </View>
        <View style={styles.bottom}>
          <ActivityIndicator size="large" color="#0000ff" />
          <Text style={{fontSize: 18, fontWeight: 'bold', color: '#000000'}}>
            By: Praveen Kumar Sharma
          </Text>
        </View>
      </View>
    );

    if (this.state.isLoading) {
      return Splash_Screen;
    }

    return (
      <View style={styles.container}>
        <FlatList
          data={this.state.dataSource}
          renderItem={({item}) => (
            <View
              style={{
                flexDirection: 'column',
                padding: 20,
                borderRadius: 25,
                margin: 20,
                backgroundColor: '#414141',
              }}>
              <Image
                style={styles.tinyLogo}
                source={{
                  uri: item.picture.large,
                }}
              />

              <View style={styles.row2}>
                <View style={styles.inputWrap2}>
                  <Text
                    style={{color: 'white', fontWeight: 'bold', fontSize: 18}}>
                    {item.name.title} {item.name.first} {item.name.last}
                  </Text>
                </View>

                <View style={styles.inputWrap}>
                  <TouchableOpacity
                    style={styles.SubmitButtonStyle2}
                    activeOpacity={0.5}
                    onPress={() => {
                      this.props.navigation.navigate('Detail', {
                        data: {item}.item,
                      });
                    }}>
                    <Text
                      style={{
                        color: 'blue',
                        textAlign: 'center',
                      }}>
                      {' '}
                      View Details{' '}
                    </Text>
                  </TouchableOpacity>
                </View>
              </View>

              <ListItem.Content>
                <ListItem.Title style={{color: 'white', fontWeight: 'bold'}}>
                  <Text style={styles.innerText}>Email Id:</Text>
                  <Text style={styles.innerText2}>{item.email}</Text>
                </ListItem.Title>
                <ListItem.Title style={{color: 'white', fontWeight: 'bold'}}>
                  <Text style={styles.innerText}>Gender:</Text>
                  <Text style={styles.innerText2}>{item.gender}</Text>
                </ListItem.Title>
                <ListItem.Title style={{color: 'white', fontWeight: 'bold'}}>
                  <Text style={styles.innerText}>Location:</Text>
                  <Text style={styles.innerText2}>
                    {item.location.street.number} {item.location.street.name}{' '}
                    {item.location.city} {item.location.state}{' '}
                    {item.location.country} {item.location.postcode}
                  </Text>
                </ListItem.Title>
                <ListItem.Title style={{color: 'white', fontWeight: 'bold'}}>
                  <Text style={styles.innerText}>DOB:</Text>
                  <Text style={styles.innerText2}>{item.dob.date}</Text>
                  {'    '}
                  <Text style={styles.innerText}>Age:</Text>
                  <Text style={styles.innerText2}>{item.dob.age}</Text>
                </ListItem.Title>
              </ListItem.Content>
            </View>
          )}
          keyExtractor={(item, index) => index.toString()}
          ItemSeparatorComponent={this.renderSeparator}
          ListHeaderComponent={this.renderHeader}
          stickyHeaderIndices={[0]}
          ListFooterComponent={this.renderFooterLoading}
          // For Footer Button
          // ListFooterComponent={this.renderFooter}

          // For auto pagination
          onEndReached={this.LoadMoreRandomData}
          onEndReachedThreshold={0.3}
        />
      </View>
    );
  }
}

//==========================================================================

class DetailScreen extends React.Component {
  render() {
    const data = this.props.navigation.getParam('data', 'nothing sent');
    return (
      <ScrollView>
        <View
          style={{
            flex: 1,
            paddingLeft: 20,
            paddingRight: 20,
            paddingTop: 20,
            backgroundColor: '#2c2c2c',
          }}>
          <Image style={styles.tinyLogo} source={{uri: data.picture.large}} />

          <View style={styles.row}>
            <View style={styles.inputWrap}>
              <TouchableOpacity
                style={styles.SubmitButtonStyle3}
                activeOpacity={0.5}
                onPress={() => {
                  Alert.alert(
                    'You have pressed the Name: \n' +
                      data.name.title +
                      ' ' +
                      data.name.first +
                      ' ' +
                      data.name.last,
                  );
                }}>
                <Text
                  style={{
                    color: 'blue',
                    textAlign: 'center',
                  }}>
                  {' '}
                  Click Me !{' '}
                </Text>
              </TouchableOpacity>
            </View>

            <View style={styles.inputWrap}>
              <TouchableOpacity
                style={styles.SubmitButtonStyle3}
                activeOpacity={0.5}
                onPress={() => {
                  Linking.openURL('https://www.accolite.com/');
                }}>
                <Text
                  style={{
                    color: 'blue',
                    textAlign: 'center',
                  }}>
                  {' '}
                  View Details{' '}
                </Text>
              </TouchableOpacity>
            </View>
          </View>
          <Text
            style={{
              textAlign: 'justify',
              fontSize: 16,
              color: '#fff',
              backgroundColor: '#414141',
            }}>
            Lorem Ipsum is simply dummy text of the printing and typesetting
            industry. Lorem Ipsum has been the industry's standard dummy text
            ever since the 1500s, when an unknown printer took a galley of type
            and scrambled it to make a type specimen book. It has survived not
            only five centuries, but also the leap into electronic typesetting,
            remaining essentially unchanged. It was popularised in the 1960s
            with the release of Letraset sheets containing Lorem Ipsum passages,
            and more recently with desktop publishing software like Aldus
            PageMaker including versions of Lorem Ipsum. Why do we use it? It is
            a long established fact that a reader will be distracted by the
            readable content of a page when looking at its layout. The point of
            using Lorem Ipsum is that it has a more-or-less normal distribution
            of letters, as opposed to using 'Content here, content here', making
            it look like readable English. Many desktop publishing packages and
            web page editors now use Lorem Ipsum as their default model text,
            and a search for 'lorem ipsum' will uncover many web sites still in
            their infancy. Various versions have evolved over the years,
            sometimes by accident, sometimes on purpose (injected humour and the
            like). Where does it come from? Contrary to popular belief, Lorem
            Ipsum is not simply random text. It has roots in a piece of
            classical Latin literature from 45 BC, making it over 2000 years
            old. Richard McClintock, a Latin professor at Hampden-Sydney College
            in Virginia, looked up one of the more obscure Latin words,
            consectetur, from a Lorem Ipsum passage, and going through the cites
            of the word in classical literature, discovered the undoubtable
            source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of "de
            Finibus Bonorum et Malorum" (The Extremes of Good and Evil) by
            Cicero, written in 45 BC. This book is a treatise on the theory of
            ethics, very popular during the Renaissance. The first line of Lorem
            Ipsum, "Lorem ipsum dolor sit amet..", comes from a line in section
            1.10.32. The standard chunk of Lorem Ipsum used since the 1500s is
            reproduced below for those interested. Sections 1.10.32 and 1.10.33
            from "de Finibus Bonorum et Malorum" by Cicero are also reproduced
            in their exact original form, accompanied by English versions from
            the 1914 translation by H. Rackham. Where can I get some? There are
            many variations of passages of Lorem Ipsum available, but the
            majority have suffered alteration in some form, by injected humour,
            or randomised words which don't look even slightly believable. If
            you are going to use a passage of Lorem Ipsum, you need to be sure
            there isn't anything embarrassing hidden in the middle of text. All
            the Lorem Ipsum generators on the Internet tend to repeat predefined
            chunks as necessary, making this the first true generator on the
            Internet. It uses a dictionary of over 200 Latin words, combined
            with a handful of model sentence structures, to generate Lorem Ipsum
            which looks reasonable. The generated Lorem Ipsum is therefore
            always free.
          </Text>
        </View>
      </ScrollView>
    );
  }
}

//=========================================================================

const AppNavigator = createStackNavigator(
  {
    Home: {
      screen: HomeScreen,
      navigationOptions: {
        headerShown: null,
      },
    },
    // Home: HomeScreen,
    Detail: DetailScreen,
  },
  {
    initialRouteName: 'Home',
  },
);

const AppContainer = createAppContainer(AppNavigator);
export default class App extends React.Component {
  render() {
    return <AppContainer />;
  }
}

//==========================================================================

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#2c2c2c',
  },
  item: {
    padding: 10,
    fontSize: 18,
    height: 44,
  },
  baseText: {
    fontSize: 30,
    fontWeight: 'bold',
    textAlign: 'center',
  },
  innerText: {
    color: 'red',
  },
  innerText2: {
    color: 'green',
  },
  tinyLogo: {
    alignSelf: 'center',
    width: 150,
    height: 250,
  },
  SubmitButtonStyle: {
    marginTop: 10,
    paddingTop: 15,
    paddingBottom: 15,
    marginLeft: 10,
    marginRight: 10,
    backgroundColor: '#414141',
    borderRadius: 10,
    width: 50,
    height: 50,
    fontSize: 26,
    fontWeight: 'bold',
  },
  inputsearch: {
    marginTop: 10,
    paddingTop: 15,
    paddingBottom: 15,
    marginLeft: 10,
    marginRight: 10,
    backgroundColor: '#414141',
    borderRadius: 5,
    height: 50,
    color: '#fff',
    fontSize: 20,
    fontWeight: 'bold',
  },
  SubmitButtonStyle2: {
    marginTop: 10,
    paddingTop: 6,
    paddingBottom: 6,
    marginLeft: 2,
    marginRight: 2,
    backgroundColor: '#414141',
    borderRadius: 3,
    color: '#000',
    borderWidth: 1,
    borderColor: '#fff',
  },
  SubmitButtonStyle3: {
    marginTop: 10,
    paddingTop: 12,
    paddingBottom: 12,
    marginLeft: 2,
    marginRight: 2,
    backgroundColor: '#2c2c2c',
    borderRadius: 3,
    color: '#000',
    borderWidth: 1,
    borderColor: '#fff',
  },
  tStyle: {
    color: '#fff',
    textAlign: 'center',
    fontWeight: 'bold',
  },
  row: {
    flex: 1,
    flexDirection: 'row',
    backgroundColor: '#2c2c2c',
  },
  row2: {
    flex: 1,
    flexDirection: 'row',
    backgroundColor: '#414141',
  },
  inputWrap: {
    flex: 1,
    borderColor: '#414141',
    marginBottom: 10,
  },
  inputWrap2: {
    marginTop: 12,
    flex: 1,
    borderColor: '#414141',
    borderBottomWidth: 1,
  },
  inputdate: {
    fontSize: 14,
    marginBottom: -12,
    color: '#6a4595',
  },
  inputcvv: {
    fontSize: 14,
    marginBottom: -12,
    color: '#6a4595',
  },
  footer: {
    padding: 10,
    justifyContent: 'center',
    alignItems: 'center',
    flexDirection: 'row',
  },
  loadMoreBtn: {
    padding: 10,
    backgroundColor: '#800000',
    borderRadius: 4,
    flexDirection: 'row',
    justifyContent: 'center',
    alignItems: 'center',
  },
  btnText: {
    color: 'white',
    fontSize: 15,
    textAlign: 'center',
  },
  SplashScreen_RootView: {
    justifyContent: 'center',
    flex: 1,
    position: 'absolute',
    width: '100%',
    height: '100%',
  },
  SplashScreen_ChildView: {
    justifyContent: 'flex-end',
    alignItems: 'center',
    backgroundColor: '#bf74ed',
    flex: 1,
  },
  bottom: {
    justifyContent: 'flex-end',
    alignItems: 'center',
    paddingBottom: 24,
    backgroundColor: '#bf74ed',
    flex: 1,
  },
});

//==============================================================================
