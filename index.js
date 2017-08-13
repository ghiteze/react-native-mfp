import { NativeModules } from 'react-native'

const TestModule = NativeModules.TestModule
const WLResourceRequestModule = NativeModules.WLResourceRequestModule

export class Test {
  constructor(name) {
    this._name = name
  }

  hello() {
    return TestModule.hello(this._name)
  }

  hihi(jsonObject) {
    return TestModule.hihi(jsonObject)
  }
}
