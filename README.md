# Re-frame Github API Example

Just a simple app that grabs the avatar of a github user.
Built on top of `re-frame`, and the get requests are made with `cljs-ajax`.

## Development Mode

### Run application:

```
lein clean
lein figwheel dev
```

Figwheel will automatically push cljs changes to the browser.

Wait a bit, then browse to [http://localhost:3449](http://localhost:3449).

## Production Build


To compile clojurescript to javascript:

```
lein clean
lein cljsbuild once min
```
