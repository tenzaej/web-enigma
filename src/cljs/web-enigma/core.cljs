(ns web-enigma.core
  (:require [reagent.core :as r :refer [atom]]
            [web-enigma.enigma :as enigma]
            [goog.dom :as dom]
            [goog.events :as events]))

(enable-console-print!)

(defonce user-input (atom ""))

(defn greeting []
  [:div.container
    [:div.card-panel.input-field.deep-purple-text
      [:h2  [:input {
                    :type "text"
                    :value @user-input
                    :placeholder "text to encode"
                    :on-change #(reset! user-input (-> % .-target .-value))}]]
            [:label "Enigma Encoder"]
            [:div.card-action
              [:input {
                :type "button"
                :class "btn-flat waves-effect hoverable waves-purple"
                :value "clear"
                :on-click #(reset! user-input "")}]]]

    [:div.card-panel.deep-purple.lighten-4
      [:div.card-content
        [:h4.card-title "encoded text: "]
        [:p.flow-text (enigma/encode @user-input)]]]])


(r/render [greeting] (js/document.getElementById "app"))
