(ns rf-api.views
    (:require [re-frame.core :as re-frame]))

(defn get-artist-name [artist-name]
  [:div
    [:input {:type "text" :value @artist-name :on-change #(re-frame/dispatch [:artist-input-change (-> % .-target .-value)])}]
    [:input {:type "button" :value "Search" on-click #(re-frame/dispatch [:search @artist-name])}]])
(defn main-panel []
  (let [name (re-frame/subscribe [:name])
        artist-name (re-frame/subscribe [:artist-name-input])]
    (fn []
      [:div "Hello from " @name
        [:div [get-artist-name artist-name]]
        [:div "Current artist name is " @artist-name]])))
