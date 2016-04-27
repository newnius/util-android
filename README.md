# util-android
Collection of utility methods, framework, etc in android

## Collection of utility methods, framework, etc
  
#### Those tools are divided as independent as possible thus They can be combined casually to create many useful things, such as spider, general DAO, logger,  IM app etc.

### Class Available:

#### CRBackgroundTask
   - Do <code>CRWhatToDo</code> in background and call <code>CRCallback</code> when finished
   - Callback is called in UI thread

#### CRCallback
   - Often use with <code>CRCallback</code> and <code>CRBackgroundTask</code> to finish a background task 

#### CRDAO
   - Provide simple interface for database access

#### CRErrorCode
   - Use errorcode instead of using <code>int</code> directly

#### CRException

#### CRLogger
   - Log message and save them

#### CRMsg
   - Extends <code>CRObject</code>
   - Often used in socket connection to exchange message

#### CRObject
   - Present an object without creating a new class
   - Note: unable to present list now

#### CRRegEx
   - Find certain string(s)
   - Validate string of *email*, *phone* etc.

#### CRSpider
   - get or post to url to get resources
   - many customized options

#### CRWhatToDo(Interface) 
   - Often use with <code>CRCallback</code> and <code>CRBackgroundTask</code> to finish a background task 

#### HashMethods (Still in test)
  - Including normally used hash methods
