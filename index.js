import { NativeModules } from 'react-native'

const TestModule = NativeModules.TestModule

export class Test {
  hihi(jsonObject) {
    return TestModule.hihi(jsonObject)
  }
}

export class WLResourceRequest {
  constructor(url, method) {
    this._url = url;
    this._method = method;
  }

  makeRequest() {
    return NativeModules.WLResourceRequestModule.makeRequest(this._url, this._method);
  }
}