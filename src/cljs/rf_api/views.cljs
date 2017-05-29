(ns rf-api.views
    (:require [re-frame.core :as re-frame]))

(defn get-user-name [user-name]
  [:div
    [:input {:type "text" :value @user-name :on-change #(re-frame/dispatch [:user-input-change (-> % .-target .-value)])}]
    [:input {:type "button" :value "Search" :on-click #(re-frame/dispatch [:search @user-name])}]])
(defn main-panel []
  (let [name (re-frame/subscribe [:name])
        user-name (re-frame/subscribe [:user-name-input])]
    (fn []
      [:div "Status: " @name
        [:div [get-user-name user-name]]
        [:div "Current user name is " @user-name]])))
