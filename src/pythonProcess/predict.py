"""
Original file - https://drive.google.com/file/d/1bycP3vrPywrky0zsXRWm66jIm728iIU0/view?usp=sharing
"""

#import packages
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

def prediction(company_handle):
  df = pd.read_csv('{}_pastdata.csv'.format(company_handle))

  

  
  
  #Saving the graph

  #Export plot with name: '{}_priceprediction.png'.format(company_handle)
  
  
  %matplotlib inline
  from matplotlib.pylab import rcParams
  rcParams['figure.figsize'] = 20,10
  rcParams['figure.figsize'] = 20,10
  from sklearn.preprocessing import MinMaxScaler
  scaler = MinMaxScaler(feature_range=(0, 1))

 #Closing prices 

  from sklearn.preprocessing import MinMaxScaler
  from keras.models import Sequential
  from keras.layers import Dense, Dropout, LSTM

#creating dataframe
  data = df.sort_index(ascending=True, axis=0)
  new_data = pd.DataFrame(index=range(0,len(df)),columns=['Date', 'Close'])
  for i in range(0,len(data)):
      new_data['Date'][i] = data['Date'][i]
      new_data['Close'][i] = data['Close'][i]

#setting index
  new_data.index = new_data.Date
  new_data.drop('Date', axis=1, inplace=True)

#creating train and test sets
  dataset = new_data.values

  train = dataset[0:1784,:]
  valid = dataset[1784:,:]

#converting dataset into x_train and y_train
  scaler = MinMaxScaler(feature_range=(0, 1))
  scaled_data = scaler.fit_transform(dataset)

  x_train, y_train = [], []
  for i in range(60,len(train)):
      x_train.append(scaled_data[i-60:i,0])
      y_train.append(scaled_data[i,0])
  x_train, y_train = np.array(x_train), np.array(y_train)

  x_train = np.reshape(x_train, (x_train.shape[0],x_train.shape[1],1))

  # create and fit the LSTM network
  model = Sequential()
  model.add(LSTM(units=50, return_sequences=True, input_shape=(x_train.shape[1],1)))
  model.add(LSTM(units=50))
  model.add(Dense(1))

  model.compile(loss='mean_squared_error', optimizer='adam')
  model.fit(x_train, y_train, epochs=1, batch_size=1, verbose=2)

  #predicting 246 values, using past 60 from the train data
  inputs = new_data[len(new_data) - len(valid) - 60:].values
  inputs = inputs.reshape(-1,1)
  inputs  = scaler.transform(inputs)

  X_test = []
  for i in range(60,inputs.shape[0]):
      X_test.append(inputs[i-60:i,0])
  X_test = np.array(X_test)

  X_test = np.reshape(X_test, (X_test.shape[0],X_test.shape[1],1))
  closing_price = model.predict(X_test)
  closing_price = scaler.inverse_transform(closing_price)

  #for plotting
  train = new_data[:1784]
  valid = new_data[1784:]
  valid['Predictions'] = closing_price


  plt.subplot(2, 1, 1)
  plt.plot(valid[['Close','Predictions']])

  plt.title("Depiction of Closing prices")
  plt.xlabel("Year")
  plt.ylabel("Closing predicted values")
  plt.legend(["Blue - Original closing price", "Orange - Predicted closing price"], loc="best")




  # Opening

  data = df.sort_index(ascending=True, axis=0)
  new_data = pd.DataFrame(index=range(0,len(df)),columns=['Date', 'Open'])
  for i in range(0,len(data)):
      new_data['Date'][i] = data['Date'][i]
      new_data['Open'][i] = data['Open'][i]

  #setting index
  new_data.index = new_data.Date
  new_data.drop('Date', axis=1, inplace=True)

  #creating train and test sets
  dataset = new_data.values

  train = dataset[0:1784,:]
  valid = dataset[1784:,:]

  #converting dataset into x_train and y_train
  scaler = MinMaxScaler(feature_range=(0, 1))
  scaled_data = scaler.fit_transform(dataset)

  x_train, y_train = [], []
  for i in range(60,len(train)):
      x_train.append(scaled_data[i-60:i,0])
      y_train.append(scaled_data[i,0])
  x_train, y_train = np.array(x_train), np.array(y_train)

  x_train = np.reshape(x_train, (x_train.shape[0],x_train.shape[1],1))

# create and fit the LSTM network
  model = Sequential()
  model.add(LSTM(units=50, return_sequences=True, input_shape=(x_train.shape[1],1)))
  model.add(LSTM(units=50))
  model.add(Dense(1))

  model.compile(loss='mean_squared_error', optimizer='adam')
  model.fit(x_train, y_train, epochs=1, batch_size=1, verbose=2)

  #predicting 246 values, using past 60 from the train data
  inputs = new_data[len(new_data) - len(valid) - 60:].values
  inputs = inputs.reshape(-1,1)
  inputs  = scaler.transform(inputs)

  X_test = []
  for i in range(60,inputs.shape[0]):
      X_test.append(inputs[i-60:i,0])
  X_test = np.array(X_test)

  X_test = np.reshape(X_test, (X_test.shape[0],X_test.shape[1],1))
  opening_price = model.predict(X_test)
  opening_price = scaler.inverse_transform(opening_price)


#for plotting
  train = new_data[:1784]
  valid = new_data[1784:]
  valid['Predictions'] = closing_price
#plt.plot(train['Open'])

  plt.subplot(2, 1, 2)
  plt.plot(valid[['Open','Predictions']])


  plt.title("Depiction of Opening prices")
  plt.xlabel("Year")
  plt.ylabel("Opening predicted values")
  plt.legend(["Blue - Original opening price", "Orange - Predicted opening price"], loc="best")
  
  from matplotlib import pyplot as plt

  plt.savefig('{}_priceprediction.png'.format(company_handle))
 
  
  
  
  return
if __name__=='__main__':
    parser = argparse.ArgumentParser(description='Opening/Closing prices')
    parser.add_argument('--company_name', default='', help='Enter the company name')
    args = parser.parse_args()
    prediction(args.company_name)
