# react-native-acquire-io

## Getting started

`$ npm install react-native-acquire-io --save`

### Mostly automatic installation

`$ react-native link react-native-acquire-io`

### Manual installation

#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-acquire-io` and add `RNAcquireIo.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNAcquireIo.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`

-   Add `import com.acquire.RNAcquireIoPackage;` to the imports at the top of the file
-   Add `new RNAcquireIoPackage()` to the list returned by the `getPackages()` method

2. Append the following lines to `android/settings.gradle`:
    ```
    include ':react-native-acquire-io'
    project(':react-native-acquire-io').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-acquire-io/android')
    ```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
    ```
      compile project(':react-native-acquire-io')
    ```

## Usage

```javascript
import RNAcquireIo from 'react-native-acquire-io';
import { DeviceEventEmitter } from 'react-native';

RNAcquireIo.setVisitorDetail({
	name: 'test',
	email: 'test@gmail.com',
	phone: '+79051112233',
	some: 'key'
});
RNAcquireIo.init('123a1');
DeviceEventEmitter.addListener(RNAcquireIo.UNREAD_MESSAGE_COUNT_UPDATE_EVENT_KEY, console.log);
RNAcquireIo.setFireBaseToken('firebase token');
RNAcquireIo.startSupportChat();
RNAcquireIo.logOut();
```
