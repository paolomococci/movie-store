<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="{{ url('css/welcome.css')}}" type="text/css" media="screen"/>
        <title>movie store</title>
    </head>
    <body>
        <div class="flex-center position-ref full-height">
            @if (Route::has('login'))
                <div class="top-right links">
                    @auth
                        <a href="{{ url('/home') }}">home</a>
                    @else
                        <a href="{{ route('login') }}">login</a>

                        @if (Route::has('register'))
                            <a href="{{ route('register') }}">register</a>
                        @endif
                    @endauth
                </div>
            @endif

            <div class="content">
                <div class="title m-b-md">
                    movie store
                </div>

                <div class="links">
                    <!-- TODO -->
                </div>
            </div>
        </div>
    </body>
</html>
