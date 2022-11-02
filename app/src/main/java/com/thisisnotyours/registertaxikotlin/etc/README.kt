package com.thisisnotyours.registertaxikotlin.etc

class README {
    //edit:
    //  MVVM 패턴이란?

    //edit:
//     Coroutine 코루틴이란?
//코루틴은 스레드와 기능적으로 같지만, 스레드에 비교하면 좀 더 가볍고 유연하며 한단계 더 진화된 병렬 프로그래밍을 위한 기술.
//edit- 하나의 스레드 내에서 여러개의 코루틴이 실행되는 개념.

    //   me: Suspend fun
//    Suspend function : 코루틴 블럭을 임시로 빠져나가는 함수. 코루틴 블럭 안에서만 호출할 수 있으며,
//    이 함수를 만나면 코루틴 블럭을 잠시 빠져나가고, 이 함수는 그대로 비동기적으로 수행된다.
//    그 후, 해당 함수의 작업이 완료되면 다시 코루틴 블럭으로 돌아와서 해당 함수의 다음부터 이어서 실행된다.
//    해당 함수의 작업이 완료되기 전까지는 코루틴 블럭 안에서 다음으로 넘어가지 않는다.

// me: suspend = '중지하다' 라는 의미.
//coroutine 에서 suspend 의 정의 = a function that could be started, paused, and resume.
//                              = 시작하고 멈추고 다시 시작할 수 있는 함수.
// suspend 란 비동기 실행을 위한 중단 지점의 의미.
// 즉, 잠시 중단(suspend)한다는 의미이고, 잠시 중단한다면 언젠가는 다시 시작(resume)된다는 뜻.
// 비동기는 동시에 일어나지 않는다는 의미. 요청과 그 결과가 동시에 일어나지 않음. 요청한 그 곳에서 결과가 나타나지 않음.
// Asynchronous : 동시에 일어나지 않는. 비동기.
// 비동기 장점 : 결과가 주어지는데 시간이 걸리더라도 그 시간 동안 다른 작업이 가능해 자원의 효율적인 사용이 가능.
//       단점 : 설계가 동기보다 복잡함
// 동기식은 동시, 즉 요청과 그 결과가 동시에 일어난 다는 의미. (A노드와 B노드 사이의 트랜잭션을 동시에 맞추겠다는 것)
// 동기식의 장점: 설계가 간단하고 직권적.
//        단점: 결과를 볼 때까지 아무것도 못하고 대기해야함.

//※ suspend 가 없다면?
// ex) 하나의 thread 가 block 될 경우, 해당 thread 는 다른 작업을 할 수 없는 block 상태에 놓이게 됨.
//  즉, blocked 상태가 끝날 때 까지 해당 thread 는 중지 상태인 것. 아무것도 못하게 됨.
//  BUT, suspend function 을 사용하면, blocked 된 상태일 때,
//  그 작업을 suspend 하고 그 기간동안 thread 에서 다른작업을 수행할 수 있다. = 자원 효율적이다.



    //me: Scope
//    Scope : 코루틴이 실행되는 범위로, 예를 들어 코루틴 튜토리얼 글에서 많이 볼 수 있는 Globalscope는 앱 전체의 생명 주기를 따른다.
//    즉, 앱이 실행중이라면 코루틴이 계속 실행될 수 있다.
//    만약 Activity와 라이프사이클을 같이 하는 scope를 만든다면 activity가 종료되기 전까지만 실행되고,
//    액티비티가 종료되면 해당 스코프를 사용한 코루틴도 같이 종료된다.
//
//  //me: Launch
//    Launch : 비동기적으로 실행될 코드 블럭을 받아서 코루틴을 실행시키는 함수
//

    //me:  Scope 의 종류
//    GlobalScope - 특정 액티비티나 프래그먼트의 생명주기와 함께 동작해서 실행 도중 별도 생명주기 관리가 필요없다.
//                   시작부터 종료까지 실행 시간이 비교적 긴 코루틴의 경우에 적합하다.
//    CoroutineScope - 필요할때만 열고 완료되면 닫아주는 코루틴 스코프에 사용하기 적합하다.
//    ViewModelScope - 뷰모델 컴포넌트를 사용한다면, ViewModel 인스턴스에서 사용하기 위해 제공되는 스코프이다.
//                     GlobalScope와 비슷하게, 뷰모델 인스턴스가 소멸될 때 자동으로 소멸되고 작업도 자연스럽게 취소된다.



    //me: Dispatchers
//    Dispatcher 를 몰라서 CoroutineScope를 안쓴 것 같은 느낌도 없잖아 있다. 그래서 Dispatcher 에 대해 좀 설명하자면,
//    코루틴을 실행 때 적당한 스레드에 할당하여 실행 도중 발생하는 pause 나 resume 를 담당한다.

//    me:  Dispatchers 종류
//    Default : CPU 를 많이 쓰는 작업에 최적화 되어있는 디스패쳐
//    IO : Input/Output 의 약자처럼 이미지 다운로드, 파일 입출력 등과 같은 입출력 작업에 최적화 되어있는 디스패쳐
//    Main : 메인이라하면 역시 UI 아니겠는가? UI 작업과 찰떡궁합인 디스패쳐
//    Unconfined : 이건 사실 좀 특이해서 참고한 설명을 그대로 적는다.
//    호출한 컨텍스트(Context)를 기본으로 사용하는 디스패쳐이다. 다만 작업이 중단된 후 다시 실행될 때 컨텍스트가 바뀌면 바뀐 컨텍스트를 따라간다.




    //me: Timber 라이브러리 사용이유/ 장점
//    1) 태그 생성에 도움
//    2) 릴리즈때 로그 출력 방지
//    3) 충돌 보고 라이브러리와 쉽게 통합 가능
//    4) 기존 코드보다 간결해짐

}